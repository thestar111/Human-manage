/**
 * 文 件 名:  RoleVo
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.role.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
public class RoleVo implements Serializable
{
	private int roleId;
	private int parentRoleId;
	private String roleType;
	private String roleName;
	private String memo;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("RoleVo{");
		sb.append ("roleId='").append (roleId).append ('\'');
		sb.append (", parentRoleId='").append (parentRoleId).append ('\'');
		sb.append (", roleType=").append (roleType);
		sb.append (", roleName='").append (roleName).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
