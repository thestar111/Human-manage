/**
 * 文 件 名:  AuthorizationService
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.security.configuration;

import com.civil.aviation.human.common.core.encryt.Coder;
import com.civil.aviation.human.common.core.utils.SessionUtils;
import com.civil.aviation.human.database.entity.Employee;
import com.civil.aviation.human.database.entity.Role;
import com.civil.aviation.human.database.mapper.LoginMapper;
import com.civil.aviation.human.database.mapper.PermsionMapper;
import com.civil.aviation.human.database.mapper.RoleMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * < 自定义 Relam >
 * 1.用户登录时，用户名密码校验
 * 2.用户系统拦截时，从数据库中获取用户权限和角色进行匹配
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class AuthorizationService extends AuthorizingRealm
{

	/**
	 *
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (AuthorizationService.class);

	@Autowired
	private LoginMapper loginMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private PermsionMapper permsionMapper;

	/**
	 * 权限验证
	 * 权限认证，为当前登录的Subject授予角色和权限
	 *
	 * @param principalCollection
	 * @return
	 * @see ：本例中该方法的调用时机为需授权资源被访问时
	 * @see ：并且每次访问需授权资源时都会执行该方法中的逻辑，这表明本例中默认并未启用AuthorizationCache
	 * @see ：如果连续访问同一个URL（比如刷新），该方法不会被重复调用，Shiro有一个时间间隔（也就是cache时间，在ehcache-shiro.xml中配置），超过这个时间间隔再刷新页面，该方法会被执行
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo (PrincipalCollection principalCollection)
	{
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo ();
		//获取当前用户
		String userAccount = (String) principalCollection.getPrimaryPrincipal ();
		Set<Role> roles = roleMapper.qryRoleByEmployeeId (userAccount);
		//设置角色类型
		Set<String> roleTypes = null;
		LOGGER.debug (String.format ("query user all Roles Set : %s", roles));
		if (null != roles && roles.size () > 0)
		{
			List<Integer> roleIds = Lists.newArrayList ();
			roleTypes = Sets.newHashSet ();
			for (Role role : roles)
			{
				roleIds.add (role.getRoleId ());
				roleTypes.add (role.getRoleType ());
			}
			Set<String> permsions = permsionMapper.qryUserAllPersion (roleIds);
			simpleAuthorizationInfo.setRoles (roleTypes);
			simpleAuthorizationInfo.setStringPermissions (permsions);
		}
		return simpleAuthorizationInfo;
	}

	/**
	 * 身份验证（是否登录系统）
	 * 用户登录系统
	 *
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo (AuthenticationToken authenticationToken)
			throws AuthenticationException
	{
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		char[] password = token.getPassword ();
		String encrytPassword = null;
		try
		{
			encrytPassword = Coder.encryptBASE64 (Coder.encryptMD5 (String.valueOf (password).getBytes ("UTF-8")));
		}
		catch (Exception e)
		{
			LOGGER.error ("user password encryt failed", e);
		}
		Employee employee = loginMapper.login (token.getUsername (), encrytPassword);
		SessionUtils.setValue (SessionUtils.EMPLOYEE_SESSION_KEY, employee);
		SessionUtils.setValue (SessionUtils.EMPLOYEE_ID_SESSION_KEY, employee.getId ());
		if (null != employee)
		{
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo (token.getUsername (),
					token.getPassword (), this.getName ());
			return authenticationInfo;
		}
		else
		{
			throw new AuthenticationException ("User Login Failed.");
		}
	}
}
