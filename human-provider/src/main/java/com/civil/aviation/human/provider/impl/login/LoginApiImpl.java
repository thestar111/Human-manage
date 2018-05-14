/**
 * 文 件 名:  LoginApiImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/20 0020
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.provider.impl.login;

import com.civil.aviation.human.api.login.LoginApi;
import com.civil.aviation.human.api.login.request.LoginRequest;
import com.civil.aviation.human.common.core.annotation.Api;
import com.civil.aviation.human.common.core.domain.Result;
import com.civil.aviation.human.common.core.utils.SessionUtils;
import com.civil.aviation.human.database.entity.Employee;
import com.civil.aviation.human.database.entity.Role;
import com.civil.aviation.human.database.mapper.LoginMapper;
import com.civil.aviation.human.database.mapper.RoleMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/20 0020
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Api
public class LoginApiImpl implements LoginApi
{
	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (LoginApiImpl.class);

	@Context
	private HttpServletResponse response;

	@Autowired
	private LoginMapper loginMapper;

	@Autowired
	private RoleMapper roleMapper;

	/**
	 * 系统登录接口
	 *
	 * @param request
	 * @param loginRequest
	 * @return
	 */
	@Override
	public Result login (HttpServletRequest request, LoginRequest loginRequest)
	{
		if (null == loginRequest)
		{
			return Result.fail ("illega params.");
		}

		if (StringUtils.isEmpty (loginRequest.getUserName ()) || StringUtils.isEmpty (loginRequest.getPassword ()))
		{
			return Result.fail ("illega params.");
		}

		/**
		 * 获取当前用户
		 */
		Subject currentUser = SecurityUtils.getSubject ();
		currentUser.logout ();
		if (! currentUser.isAuthenticated ())
		{
			UsernamePasswordToken token = new UsernamePasswordToken (loginRequest.getUserName (),
					loginRequest.getPassword ());
			try
			{
				currentUser.login (token);
				Employee employee = (Employee) SessionUtils.getValue (SessionUtils.EMPLOYEE_SESSION_KEY);
				Set<Role> roles = roleMapper.qryRoleByEmployeeId (employee.getId ());
				if (null != roles && roles.size () > 0)
				{
					Iterator roleIterable = roles.iterator ();
					if (roleIterable.hasNext ())
					{
						Role role = (Role) roleIterable.next ();
						Cookie type = new Cookie ("type", role.getRoleType ());
						type.setPath ("/");
						type.setMaxAge (3600 * 24 * 7);
						type.setHttpOnly (true);
						response.addCookie (type);
					}
				}
				if (null == employee.getSupplement ())
				{
					employee.setSupplement (0);
				}
				Cookie supplement = new Cookie ("supplement", String.valueOf (employee.getSupplement ()));
				supplement.setPath ("/");
				supplement.setMaxAge (3600 * 24 * 7);
				response.addCookie (supplement);
				return Result.success (employee.getId () + "###" + employee.getName ());
			}
			catch (Exception e)
			{
				LOGGER.error ("User Login Failed.", e);
				return Result.fail ("User Login Failed.");
			}
		}
		else
		{
			Employee employee = (Employee) SessionUtils.getValue (SessionUtils.EMPLOYEE_SESSION_KEY);
			return Result.success (employee.getId () + "###" + employee.getName ());
		}
	}

	/**
	 * 系统登出接口
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@Override
	public void loginOut (HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			// 先登出
			if (SecurityUtils.getSubject ().isAuthenticated () || null != SecurityUtils.getSubject ().getSession ())
			{
				request.getSession ().removeAttribute (SessionUtils.EMPLOYEE_SESSION_KEY);
				request.getSession ().removeAttribute (SessionUtils.EMPLOYEE_ID_SESSION_KEY);
				SecurityUtils.getSubject ().logout ();
			}
			response.sendRedirect ("/login.html");
		}
		catch (IOException e)
		{
			LOGGER.error ("login out exit system exception.", e);
		}
	}
}
