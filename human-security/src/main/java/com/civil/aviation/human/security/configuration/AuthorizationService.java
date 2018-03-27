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

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;

/**
 * < 自定义 Relam >
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class AuthorizationService extends AuthorizingRealm
{

	private static final Logger LOGGER = LoggerFactory.getLogger (AuthorizationService.class);

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
		Map<String, Set<String>> roleAndPermsion = AdminService.queryUserPer (userAccount);
		LOGGER.debug (String.format ("query user all permsion Set : %s", roleAndPermsion));
		if (null != roleAndPermsion)
		{
			Set<String> roles = roleAndPermsion.get ("roleSet");
			Set<String> permsions = roleAndPermsion.get ("permsionSet");
			simpleAuthorizationInfo.setRoles (roles);
			simpleAuthorizationInfo.setStringPermissions (permsions);
		}
		return simpleAuthorizationInfo;
	}

	/**
	 * 身份验证（是否登录系统）
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

		return null;
	}
}
