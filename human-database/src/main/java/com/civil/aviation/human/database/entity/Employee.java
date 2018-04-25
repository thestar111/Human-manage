/**
 * 文 件 名:  Employee
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
 * <员工信息实体>
 *
 * @author zping
 * @version 2018/3/20 0020
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class Employee implements Serializable
{
	private String id;

	private String name;

	private String password;

	private String englishName;

	private String sex;

	private String homeAddr;

	private String birthday;

	private String tel;

	private String nation;

	private String email;

	private String lastUpdateTime;

	private String createTime;

	private String department;

	private String salary;

	private String job;

	private String rank;

	/**
	 * 部门名称
	 */
	private String departName;

	/**
	 * 职级名称
	 */
	private String rankName;

	/**
	 * 职位称呼
	 */
	private String jobName;

	/**
	 * 是否需要补充信息（0：要补充  1：已补充）
	 */
	private Integer supplement;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("Employee{");
		sb.append ("id='").append (id).append ('\'');
		sb.append (", name='").append (name).append ('\'');
		sb.append (", password='").append ("******").append ('\'');
		sb.append (", englishName='").append (englishName).append ('\'');
		sb.append (", sex='").append (sex).append ('\'');
		sb.append (", homeAddr='").append (homeAddr).append ('\'');
		sb.append (", birthday='").append (birthday).append ('\'');
		sb.append (", tel='").append (tel).append ('\'');
		sb.append (", nation='").append (nation).append ('\'');
		sb.append (", email='").append (email).append ('\'');
		sb.append (", lastUpdateTime='").append (lastUpdateTime).append ('\'');
		sb.append (", createTime='").append (createTime).append ('\'');
		sb.append (", department='").append (department).append ('\'');
		sb.append (", salary='").append (salary).append ('\'');
		sb.append (", job='").append (job).append ('\'');
		sb.append (", rank='").append (rank).append ('\'');
		sb.append (", departName='").append (departName).append ('\'');
		sb.append (", rankName='").append (rankName).append ('\'');
		sb.append (", jobName='").append (jobName).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
