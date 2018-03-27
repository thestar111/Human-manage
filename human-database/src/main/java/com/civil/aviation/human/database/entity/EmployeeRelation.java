/**
 * 文 件 名:  EmployeeRelation
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/20 0020
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.database.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/20 0020
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class EmployeeRelation implements Serializable
{
	private int id;

	private String employeeId;

	private int departmentId;

	private int rankId;

	private int jobId;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("EmployeeRelation{");
		sb.append ("id=").append (id);
		sb.append (", employeeId='").append (employeeId).append ('\'');
		sb.append (", departmentId=").append (departmentId);
		sb.append (", rankId=").append (rankId);
		sb.append (", jobId=").append (jobId);
		sb.append ('}');
		return sb.toString ();
	}
}
