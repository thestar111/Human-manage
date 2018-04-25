/**
 * 文 件 名:  Role
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
 * <角色信息>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class Role implements Serializable
{
	private Integer roleId;
	private Integer parentRoleId;
	private String roleType;
	private String roleName;
	private String memo;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("Role{");
		sb.append ("roleId='").append (roleId).append ('\'');
		sb.append (", parentRoleId='").append (parentRoleId).append ('\'');
		sb.append (", roleType=").append (roleType);
		sb.append (", roleName='").append (roleName).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
