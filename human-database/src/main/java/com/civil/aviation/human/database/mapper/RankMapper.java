/**
 * 文 件 名:  RankMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/21 0021
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.database.mapper;

import com.civil.aviation.human.database.entity.Rank;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <员工职级Mapper>
 *
 * @author zping
 * @version 2018/3/21 0021
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface RankMapper
{
	/**
	 * 添加职级信息
	 *
	 * @param rank
	 * @return
	 * @throws SQLException
	 */
	int add (Rank rank) throws SQLException;

	/**
	 * 添加职级信息
	 *
	 * @param rank
	 * @return
	 * @throws SQLException
	 */
	int modify (Rank rank) throws SQLException;

	/**
	 * 添加职级信息
	 *
	 * @param rankId
	 * @return
	 * @throws SQLException
	 */
	int delete (int rankId) throws SQLException;

	/**
	 * 根据编号查询职级信息
	 *
	 * @param rankId
	 * @return
	 * @throws SQLException
	 */
	Rank findById (Integer rankId) throws SQLException;

	/**
	 * 根据条件查询职级信息
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	List<Rank> findByCondition (Map<String, Object> params) throws SQLException;

	/**
	 * 根据条件查询职级总数信息
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	int findCountByCondition (Map<String, Object> params) throws SQLException;
}
