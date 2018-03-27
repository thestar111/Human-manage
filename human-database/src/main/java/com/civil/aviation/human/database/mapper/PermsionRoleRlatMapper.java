/**
 * 文 件 名:  AdminMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.database.mapper;

import com.civil.aviation.human.database.entity.PermsionRoleRlat;

import java.util.List;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface PermsionRoleRlatMapper
{
	/**
	 * 添加
	 *
	 * @param permsionRoleRlat
	 */
	void add (PermsionRoleRlat permsionRoleRlat);

	/**
	 * 查询
	 *
	 * @param roleId
	 * @return
	 */
	List<PermsionRoleRlat> query (String roleId);
}
