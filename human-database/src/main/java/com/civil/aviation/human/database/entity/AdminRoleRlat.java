/**
 * 文 件 名:  AdminRoleRlat
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.database.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <管理员角色关系>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AdminRoleRlat implements Serializable
{
	private Integer id;
	private String adminId;
	private Integer roleId;
	private Integer roleType;
	private String roleName;
	private String memo;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("AdminRoleRlat{");
		sb.append ("id='").append (id).append ('\'');
		sb.append (", adminId='").append (adminId).append ('\'');
		sb.append (", roleId='").append (roleId).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
