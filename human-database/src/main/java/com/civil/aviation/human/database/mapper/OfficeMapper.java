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
import com.civil.aviation.human.database.entity.Office;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <部门Mapper接口>
 *
 * @author zping
 * @version 2018/3/24 0024
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface OfficeMapper
{
	/**
	 * 添加科室信息
	 *
	 * @param office
	 * @return
	 * @throws SQLException
	 */
	int add(Office office) throws SQLException;

	/**
	 * 修改科室信息
	 *
	 * @param office
	 * @return
	 * @throws SQLException
	 */
	int modify(Office office) throws SQLException;

	/**
	 * 删除科室信息
	 *
	 * @param officId
	 * @return
	 * @throws SQLException
	 */
	int delete(int officId) throws SQLException;

	/**
	 * 查询科室信息
	 *
	 * @param officeId
	 * @return
	 * @throws SQLException
	 */
	Office findById(int officeId) throws SQLException;

	/**
	 * 查询科室信息
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	List<Office> findByCondition(Map<String, Object> params) throws SQLException;

	/**
	 * 查询科室总数
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	Integer findCountByCondition(Map<String, Object> params) throws SQLException;
}
