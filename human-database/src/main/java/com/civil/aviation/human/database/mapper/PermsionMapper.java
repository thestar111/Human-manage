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

import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述> <功能详细描述>
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
	void add (Permsion permsion);

	/**
	 * 查询
	 *
	 * @param params
	 * @return
	 */
	List<Permsion> query (Map<String, Object> params);

	/**
	 * 总数
	 *
	 * @param params
	 * @return
	 */
	int count (Map<String, Object> params);

	/**
	 * 查询
	 *
	 * @param permsionId
	 * @return
	 */
	Permsion find (String permsionId);
}
