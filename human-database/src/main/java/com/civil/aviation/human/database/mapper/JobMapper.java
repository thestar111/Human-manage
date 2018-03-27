/**
 * 文 件 名:  JobMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/21 0021
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.database.mapper;

import com.civil.aviation.human.database.entity.Job;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/21 0021
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface JobMapper
{
	/**
	 * 添加职位称呼信息
	 *
	 * @param job
	 * @return
	 * @throws SQLException
	 */
	int add (Job job) throws SQLException;

	/**
	 * 修改职位称呼信息
	 *
	 * @param job
	 * @return
	 * @throws SQLException
	 */
	int modify (Job job) throws SQLException;

	/**
	 * 删除职位称呼信息
	 *
	 * @param jobId
	 * @return
	 * @throws SQLException
	 */
	int delete (int jobId) throws SQLException;

	/**
	 * 查询部门信息
	 *
	 * @param jobId
	 * @return
	 * @throws SQLException
	 */
	Job findById (int jobId) throws SQLException;

	/**
	 * 查询职位称呼信息
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	List<Job> findByCondition (Map<String, Object> params) throws SQLException;

	/**
	 * 查询职位称呼信息
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	int findCountByCondition (Map<String, Object> params) throws SQLException;
}
