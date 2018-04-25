/**
 * 文 件 名:  QryAssessResultByEmployRequest
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.assess.request;

import com.civil.aviation.human.api.base.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <根据员工编号查询考核成绩>
 *
 * @author zping
 * @version 2018/4/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QryAssessResultByEmployRequest extends BaseRequest
{
	/**
	 * 员工编号
	 */
	private String employeeId;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QryAssessResultByEmployRequest{");
		sb.append ("employeeId='").append (employeeId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
