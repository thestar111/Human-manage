/**
 * 文 件 名:  QryEmployeeConditionRequest
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.user.request;

import com.civil.aviation.human.api.base.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/22 0022
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QryEmployeeConditionRequest extends BasePageRequest
{
	private String name;

	private int department;

	private int rank;

	private int job;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QryEmployeeConditionRequest{");
		sb.append ("name='").append (name).append ('\'');
		sb.append (", department=").append (department);
		sb.append (", rank=").append (rank);
		sb.append (", job=").append (job);
		sb.append ('}');
		return sb.toString ();
	}
}
