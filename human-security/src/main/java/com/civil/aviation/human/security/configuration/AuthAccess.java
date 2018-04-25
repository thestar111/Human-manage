/**
 * 文 件 名:  AuthAccess
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.security.configuration;

import com.civil.aviation.human.common.core.cons.Constants;
import com.civil.aviation.human.common.core.domain.Result;
import com.quanten.core.utils.JSONSerialize;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * <用户权限拦截管理器>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class AuthAccess extends AccessControlFilter
{

	private static final Logger LOGGER = LoggerFactory.getLogger (OnlineAccess.class);

	/**
	 * 用户权限拦截管理器
	 * 1.管理员配置具体权限路径配置
	 * 2.用户访问给URL路径时，该方法进行拦截
	 *
	 * @param servletRequest
	 * @param servletResponse
	 * @param o
	 * @return
	 * @throws Exception
	 */
	@Override
	protected boolean isAccessAllowed (ServletRequest servletRequest, ServletResponse servletResponse, Object o)
			throws Exception
	{
		//shiro中配置url拦截的权限url部分
		String pers[] = (String[]) o;
		LOGGER.debug (String.format ("HUMAN.AuthAccess.isAccessAllowed config urls .... %s", pers));
		if (pers == null || pers.length <= 0)
		{
			return true;
		}
		LOGGER.info ("permission filter auth url ： " + pers);
		//当前登录用户
		Subject subject = SecurityUtils.getSubject ();
		boolean permittedAll = true;
		if (! subject.hasRole ("2"))
		{
			for (String ps : pers)
			{
				String[] parray = ps.split (",");
				boolean isPermitted = false;
				for (String s : parray)
				{
					isPermitted = isPermitted || subject.isPermitted (s);
					if (isPermitted)
					{
						break;
					}
				}
				permittedAll = permittedAll && isPermitted;
			}
		}
		if (permittedAll)
		{
			return true;
		}
		return false;
	}

	/**
	 * isAccessAllowed
	 * 1.返回false  会执行该方法
	 *
	 * @param servletRequest
	 * @param servletResponse
	 * @return
	 * @throws Exception
	 */
	@Override
	protected boolean onAccessDenied (ServletRequest servletRequest, ServletResponse servletResponse) throws Exception
	{
		HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
		httpResponse.setCharacterEncoding (Constants.MediaType.ENCODE_UTF8);
		httpResponse.setContentType (Constants.MediaType.APPLICATION_JSON_UTF8);
		PrintWriter writer = httpResponse.getWriter ();
		Result result = new Result ();
		result.setResultCode (Constants.ResultCode.FAILED);
		result.setResultMessage ("You had no authorization.");
		writer.print (JSONSerialize.toJson (result));
		return false;
	}
}
