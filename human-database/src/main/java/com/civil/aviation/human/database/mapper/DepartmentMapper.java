/**
 * 文 件 名:  DepartmentMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/24 0024
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.database.mapper;

import com.civil.aviation.human.database.entity.Department;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/24 0024
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface DepartmentMapper
{
	/**
	 * 添加部门信息
	 *
	 * @param department
	 * @return
	 * @throws SQLException
	 */
	int add (Department department) throws SQLException;

	/**
	 * 修改部门信息
	 *
	 * @param department
	 * @return
	 * @throws SQLException
	 */
	int modify (Department department) throws SQLException;

	/**
	 * 删除部门信息
	 *
	 * @param departmentId
	 * @return
	 * @throws SQLException
	 */
	int delete (int departmentId) throws SQLException;

	/**
	 * 查询部门信息
	 *
	 * @param departmentId
	 * @return
	 * @throws SQLException
	 */
	Department findById (int departmentId) throws SQLException;

	/**
	 * 查询部门信息
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	List<Department> findByCondition (Map<String, Object> params) throws SQLException;

	/**
	 * 查询部门总数
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	Integer findCountByCondition (Map<String, Object> params) throws SQLException;
}
