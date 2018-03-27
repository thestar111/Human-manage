/**
 * 文 件 名:  EmployeeRelationMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/21 0021
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.database.mapper;

import com.civil.aviation.human.database.entity.EmployeeRelation;

import java.sql.SQLException;

/**
 * <员工关系Mapper>
 *
 * @author zping
 * @version 2018/3/21 0021
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface EmployeeRelationMapper
{
	/**
	 * 添加员工关系
	 *
	 * @param employeeRelation
	 * @return
	 * @throws SQLException
	 */
	int add (EmployeeRelation employeeRelation) throws SQLException;

	/**
	 * 修改员工关系
	 *
	 * @param employeeRelation
	 * @return
	 * @throws SQLException
	 */
	int modify (EmployeeRelation employeeRelation) throws SQLException;

	/**
	 * 删除员工关系
	 *
	 * @param employeeRelationId
	 * @return
	 * @throws SQLException
	 */
	int delete (int employeeRelationId) throws SQLException;

	/**
	 * 根据员工关系编号查询
	 *
	 * @param employeeRelationId
	 * @return
	 * @throws SQLException
	 */
	EmployeeRelation findById (String employeeRelationId) throws SQLException;
}
