/**
 * 文 件 名:  ResetPasswordRequest
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/28 0028
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.user.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/28 0028
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
@NoArgsConstructor
public class ResetPasswordRequest implements Serializable
{
	private String employeeId;

	private String password;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("ResetPasswordRequest{");
		sb.append ("employeeId='").append (employeeId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
