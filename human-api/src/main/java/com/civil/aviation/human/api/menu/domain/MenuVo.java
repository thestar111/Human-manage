/**
 * 文 件 名:  MenuVo
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.menu.domain;

import java.io.Serializable;

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
public class MenuVo implements Serializable
{
	/**
	 * 菜单编号
	 */
	private int menuId;

	/**
	 * 菜单名称
	 */
	private String menuName;

	/**
	 * 父菜单编号
	 */
	private int parentMenuId;

	/**
	 * 菜单类型
	 */
	private Integer menuType;

	/**
	 * 是否叶子节点
	 */
	private Integer leaf;

	/**
	 * 菜单序号
	 */
	private Integer sort;

	/**
	 * 菜单链接地址
	 */
	private String menuUrl;

	/**
	 * 菜单描述
	 */
	private String memo;

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("Menu{");
		sb.append ("menuId='").append (menuId).append ('\'');
		sb.append (", menuName='").append (menuName).append ('\'');
		sb.append (", parentMenuId='").append (parentMenuId).append ('\'');
		sb.append (", menuType=").append (menuType);
		sb.append (", leaf=").append (leaf);
		sb.append (", sort=").append (sort);
		sb.append (", menuUrl='").append (menuUrl).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
