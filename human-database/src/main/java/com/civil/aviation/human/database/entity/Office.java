/**
 * 文 件 名:  Department
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
 * <科室信息实体>
 *
 * @author zping
 * @version 2018/3/20 0020
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class Office implements Serializable
{

	private int id;

	private String name;

	private String createTime;
	/**
	 * 部门
	 */
	private String department;

	private String memo;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("Department{");
		sb.append ("id=").append (id);
		sb.append (", name='").append (name).append ('\'');
		sb.append (", createTime='").append (createTime).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append (", department='").append (department).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
