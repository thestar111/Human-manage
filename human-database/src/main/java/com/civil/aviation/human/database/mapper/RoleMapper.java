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

import com.civil.aviation.human.database.entity.Role;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <员工角色信息Mapper>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface RoleMapper
{
	/**
	 * 添加
	 *
	 * @param role
	 */
	int add (Role role);

	/**
	 * 查询
	 *
	 * @param params
	 * @return
	 */
	List<Role> query (Map<String, Object> params);

	/**
	 * 总数
	 *
	 * @param params
	 * @return
	 */
	int count (Map<String, Object> params);

	/**
	 * 修改
	 *
	 * @param role
	 */
	int modify (Role role);

	/**
	 * shanghcu
	 *
	 * @param roleId
	 */
	int delete (int roleId);

	/**
	 * 查询
	 *
	 * @param roleId
	 * @return
	 */
	Role find (int roleId);

	/**
	 * 根据员工编号查询角色信息
	 *
	 * @param employeeId
	 * @return
	 */
	Set<Role> qryRoleByEmployeeId (String employeeId);
}
