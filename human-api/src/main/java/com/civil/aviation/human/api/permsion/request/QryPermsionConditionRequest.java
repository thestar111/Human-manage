/**
 * 文 件 名:  CreatePermsionRequest
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.permsion.request;

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
public class QryPermsionConditionRequest extends BasePageRequest
{
	/**
	 * 权限名称
	 */
	private String permsionName;

	/**
	 * 角色编号
	 */
	private int roleId;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QryPermsionConditionRequest{");
		sb.append ("permsionName='").append (permsionName).append ('\'');
		sb.append (", roleId=").append (roleId);
		sb.append ('}');
		return sb.toString ();
	}
}
