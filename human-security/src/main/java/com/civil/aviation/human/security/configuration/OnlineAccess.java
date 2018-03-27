/**
 * 文 件 名:  OnlineAccess
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * <用户会话访问控制>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class OnlineAccess extends AccessControlFilter
{
	/**
	 * 日志生成器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (OnlineAccess.class);

	/**
	 * 登录地址
	 */
	private static final String LOGIN_PAGE = "/login";

	/**
	 * 权限拦截器，是否允许访问，通过返回true，否则false
	 *
	 * @param servletRequest
	 * @param servletResponse
	 * @param mappedValue     就是[urls]配置中拦截器参数部分
	 * @return
	 * @throws Exception
	 */
	@Override
	protected boolean isAccessAllowed (ServletRequest servletRequest, ServletResponse servletResponse,
			Object mappedValue) throws Exception
	{
		Subject currentUser = SecurityUtils.getSubject ();
		if (currentUser.isAuthenticated ())
		{
			return true;
		}
		LOGGER.debug ("AccessControlFilter.isAccessAllowed user not login.");
		return false;
	}

	/**
	 * 当访问拒绝时，上面那个方式返回false时，执行该方法
	 *
	 * @param servletRequest
	 * @param servletResponse
	 * @return
	 * @throws Exception
	 */
	@Override
	protected boolean onAccessDenied (ServletRequest servletRequest, ServletResponse servletResponse) throws Exception
	{

		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		if (isAjax (request))
		{
			response.setCharacterEncoding (Constants.MediaType.ENCODE_UTF8);
			response.setContentType (Constants.MediaType.APPLICATION_JSON_UTF8);
			PrintWriter print = response.getWriter ();
			Result result = new Result ();
			result.setResultCode (Constants.ResultCode.NOT_LOGIN);
			result.setResultMessage ("user not login");
			print.write (JSONSerialize.toJson (result));
		}
		else
		{
			response.sendRedirect (LOGIN_PAGE);
		}
		return false;
	}

	/**
	 * is ajax http
	 *
	 * @param request
	 * @return
	 */
	public static boolean isAjax (HttpServletRequest request)
	{
		boolean ajax = "XMLHttpRequest".equals (request.getHeader ("X-Requested-With"));
		String ajaxFlag = null == request.getParameter ("ajax") ? "false" : request.getParameter ("ajax");
		boolean isAjax = ajax || ajaxFlag.equalsIgnoreCase ("true");
		return isAjax;
	}
}
