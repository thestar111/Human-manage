/**
 * 文 件 名:  LoginRequest
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.login.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class LoginRequest implements Serializable
{
	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 用户密码
	 */
	private String password;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("LoginRequest{");
		sb.append ("userName='").append (userName).append ('\'');
		sb.append (", password='").append ("******").append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
