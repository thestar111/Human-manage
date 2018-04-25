/**
 * 文 件 名:  Result
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.common.core.domain;

import com.civil.aviation.human.common.core.cons.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class Result implements Serializable
{
	/**
	 * 返回结果码
	 */
	private String resultCode = "0";

	/**
	 * 返回结果消息
	 */
	private String resultMessage = "success";

	/**
	 * @param resultCode
	 * @param resultMessage
	 */
	public Result (String resultCode, String resultMessage)
	{
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}

	/**
	 * 构造失败
	 *
	 * @param resultMessage
	 * @return
	 */
	public static Result fail (String resultMessage)
	{
		return new Result (Constants.ResultCode.FAILED, resultMessage);
	}

	/**
	 * 构造成功
	 *
	 * @param resultMessage
	 * @return
	 */
	public static Result success (String resultMessage)
	{
		return new Result (Constants.ResultCode.SUCCESS, resultMessage);
	}

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("Result{");
		sb.append ("resultCode='").append (resultCode).append ('\'');
		sb.append (", resultMessage='").append (resultMessage).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
