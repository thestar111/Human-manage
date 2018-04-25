/*
 * 文 件 名:  UserServiceImpl.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2016-6-17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.common.core.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <Session Util>
 *
 * @author zping
 * @version UBSS V100R001 2016-6-17
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class SessionUtils
{

	/**
	 * 管理员
	 */
	public final static String EMPLOYEE_SESSION_KEY = "employee";

	/**
	 * 管理员账号
	 */
	public final static String EMPLOYEE_ID_SESSION_KEY = "employeeId";

	/**
	 * Get value from session
	 *
	 * @param key
	 * @return
	 */
	public static final Object getValue (String key)
	{
		Subject currentUser = SecurityUtils.getSubject ();
		if (null != currentUser)
		{
			Session session = currentUser.getSession ();
			if (null != session)
			{
				return session.getAttribute (key);
			}
		}
		return null;
	}

	/**
	 * set value session
	 *
	 * @param key
	 * @param value
	 */
	public static final void setValue (String key, Object value)
	{
		Subject currentUser = SecurityUtils.getSubject ();
		if (currentUser != null)
		{
			Session session = currentUser.getSession ();
			if (null != session)
			{
				session.setAttribute (key, value);
			}
		}
	}

	/**
	 * 根据名字获取cookie
	 *
	 * @param request
	 * @param name    cookie名字
	 * @return
	 */
	public static Cookie getCookieByName (HttpServletRequest request, String name)
	{
		Map<String, Cookie> cookieMap = ReadCookieMap (request);
		if (cookieMap.containsKey (name))
		{
			Cookie cookie = (Cookie) cookieMap.get (name);
			return cookie;
		}
		else
		{
			return null;
		}
	}

	/**
	 * 将cookie封装到Map里面
	 *
	 * @param request
	 * @return
	 */
	private static Map<String, Cookie> ReadCookieMap (HttpServletRequest request)
	{
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie> ();
		Cookie[] cookies = request.getCookies ();
		if (null != cookies)
		{
			for (Cookie cookie : cookies)
			{
				cookieMap.put (cookie.getName (), cookie);
			}
		}
		return cookieMap;
	}
}
