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
import com.civil.aviation.human.common.core.exception.HumanException;

import javax.servlet.http.HttpServletRequest;

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
	 * 系统登录接口
	 *
	 * @param request
	 * @param loginRequest
	 * @return
	 */
	@Override
	public Result login (HttpServletRequest request, LoginRequest loginRequest)
	{
		throw new HumanException ("457889", "dsdwerew");
		//return new Result ();
	}
}
