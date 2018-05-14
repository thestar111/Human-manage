/**
 * 文 件 名:  EmployeeMappper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/21 0021
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.database.mapper;

import com.civil.aviation.human.database.entity.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <员工Mapper>
 *
 * @author zping
 * @version 2018/3/21 0021
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface EmployeeMappper
{
	/**
	 * 添加员工
	 *
	 * @param employee
	 * @return
	 * @throws SQLException
	 */
	int add (Employee employee) throws SQLException;

	/**
	 * 修改员工
	 *
	 * @param employee
	 * @return
	 * @throws SQLException
	 */
	int modify (Employee employee) throws SQLException;

	/**
	 * 删除员工信息
	 *
	 * @param employeeId
	 * @return
	 * @throws SQLException
	 */
	int delete (String employeeId) throws SQLException;

	/**
	 * 查询员工列表信息
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	List<Employee> queryEmploy (Map<String, Object> params) throws SQLException;

	/**
	 * 查询新注册的员工列表信息
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	List<Employee> querySupplementEmploy (Map<String, Object> params) throws SQLException;

	/**
	 * 查询新注册的员工总数
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	int querySupplementEmployCount (Map<String, Object> params) throws SQLException;

	/**
	 * 查询能参与考核成绩员工列表信息
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	List<Employee> queryAssessResultEmploy (Map<String, Object> params) throws SQLException;

	/**
	 * 查询能参与考核成绩员工列表信息总数
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	int queryAssessResultEmployCount (Map<String, Object> params) throws SQLException;

	/**
	 * 查询需要考核员工列表信息
	 *
	 * @param departmentId
	 * @param rankId
	 * @param discussant   评论人
	 * @return
	 * @throws SQLException
	 */
	List<Employee> queryAssessEmploy (Integer departmentId, Integer rankId, String discussant, String topicId) throws SQLException;

	/**
	 * 查询员工
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	int queryCountByCondition (Map<String, Object> params) throws SQLException;

	/**
	 * 查询员工信息
	 *
	 * @param employeeId
	 * @return
	 * @throws SQLException
	 */
	Employee queryEmployById (String employeeId) throws SQLException;

	/**
	 * @param employeeId
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	int resetPassword (String employeeId, String password) throws SQLException;

	/**
	 * 修改密码
	 *
	 * @param employeeId
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	int modifyPassword (String employeeId, String password, String oldPassword) throws SQLException;
}
