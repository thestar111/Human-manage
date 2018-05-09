/**
 * 文 件 名:  DepartmentVo
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.office.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * <科室实体VO信息>
 *
 * @author zping
 * @version 2018/3/22 0022
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
@NoArgsConstructor
public class OfficeVo implements Serializable
{

	/** 业务编号 */
	private Integer officeId;
	/** 部门名称 */
	private String name;
	/** 创建时间 */
	private String createTime;
	/** 部门描述 */
	private String memo;
	/** 部门编号 */
	private String departmentId;
	/** 科室负责人*/
	private String manager;
	/** 电话号码*/
	private String tel;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("DepartmentVo{");
		sb.append ("officeId=").append (officeId);
		sb.append (", name='").append (name).append ('\'');
		sb.append (", createTime='").append (createTime).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append (", departmentId='").append (departmentId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
