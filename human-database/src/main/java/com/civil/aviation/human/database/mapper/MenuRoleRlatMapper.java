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
import com.civil.aviation.human.database.entity.MenuRoleRlat;

import java.sql.SQLException;
import java.util.List;

/**
 * <菜单角色关系Mapper>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface MenuRoleRlatMapper
{
	/**
	 * 添加菜单角色关系
	 *
	 * @param menuRoleRlat
	 * @return
	 * @throws SQLException
	 */
	int add (MenuRoleRlat menuRoleRlat) throws SQLException;

	/**
	 * 根据菜单编号、角色编号删除菜单角色关系
	 *
	 * @param menuId
	 * @param roleId
	 * @return
	 * @throws SQLException
	 */
	int delete (int menuId, int roleId) throws SQLException;

	/**
	 * 根据员工编号查询所有的菜单信息
	 *
	 * @param employeeId
	 * @return
	 * @throws SQLException
	 */
	List<Menu> findAllMenu (String employeeId) throws SQLException;
}
