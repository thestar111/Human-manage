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

import com.civil.aviation.human.database.entity.Permsion;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <员工权限管理Mapper>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface PermsionMapper
{
	/**
	 * 添加
	 *
	 * @param permsion
	 */
	int add (Permsion permsion) throws SQLException;

	/**
	 * 查询
	 *
	 * @param params
	 * @return
	 */
	List<Permsion> query (Map<String, Object> params) throws SQLException;

	/**
	 * 总数
	 *
	 * @param params
	 * @return
	 */
	int count (Map<String, Object> params) throws SQLException;

	/**
	 * 查询
	 *
	 * @param permsionId
	 * @return
	 */
	Permsion find (Integer permsionId) throws SQLException;

	/**
	 * 根据用户角色编号
	 *
	 * @param roleIds
	 * @return
	 */
	Set<String> qryUserAllPersion (List<Integer> roleIds);

	/**
	 * 修改权限信息
	 *
	 * @param permsion
	 * @return
	 * @throws SQLException
	 */
	int modify (Permsion permsion) throws SQLException;

	/**
	 * 删除权限信息
	 *
	 * @param permsionId
	 * @return
	 * @throws SQLException
	 */
	int delete (Integer permsionId) throws SQLException;
}
