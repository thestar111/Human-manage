/**
 * 文 件 名:  AdminService
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/8/9 0009
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.security.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;

/**
 * <管理员服务>
 *
 * @author zping
 * @version 2017/8/9 0009
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class AdminService
{

	private static final Logger LOGGER = LoggerFactory.getLogger (AdminService.class);

	/**
	 * 查询用户权限信息
	 *
	 * @param account
	 * @return
	 */
	public static Map<String, Set<String>> queryUserPer (final String account)
	{
		Map<String, Set<String>> roleAndPermsion = null;

		return roleAndPermsion;
	}

	/**
	 * 根据
	 *
	 * @param account
	 */
	public static boolean findByAccount (final String url, final String account, final String password)
	{

		return false;
	}
}
