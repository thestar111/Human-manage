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

import com.civil.aviation.human.database.entity.Menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <菜单Mapper>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface MenuMapper
{
	/**
	 * 添加菜单信息
	 *
	 * @param menu
	 * @return
	 * @throws SQLException
	 */
	int add (Menu menu) throws SQLException;

	/**
	 * 更新菜单信息
	 *
	 * @param menu
	 * @return
	 * @throws SQLException
	 */
	int update (Menu menu) throws SQLException;

	/**
	 * 删除菜单信息
	 *
	 * @param menuId
	 * @return
	 * @throws SQLException
	 */
	int delete (int menuId) throws SQLException;

	/**
	 * @param menuId
	 * @return
	 * @throws SQLException
	 */
	Menu findById (int menuId) throws SQLException;

	/**
	 * 查询菜单信息
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	List<Menu> queryAll (Map<String, Object> params) throws SQLException;

	/**
	 * 查询菜单总数信息
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	int queryCount (Map<String, Object> params) throws SQLException;
}
