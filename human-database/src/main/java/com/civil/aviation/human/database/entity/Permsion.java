/**
 * 文 件 名:  Permsion
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
 * <权限信息>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class Permsion implements Serializable
{
	private int permsionId;
	private String permsionName;
	private String permsionFlag;
	private int menuId;
	private String memo;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("Permsion{");
		sb.append ("permsionId='").append (permsionId).append ('\'');
		sb.append (", permsionName='").append (permsionName).append ('\'');
		sb.append (", permsionFlag='").append (permsionFlag).append ('\'');
		sb.append (", menuId='").append (menuId).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
