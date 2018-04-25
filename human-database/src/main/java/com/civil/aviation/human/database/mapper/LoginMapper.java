/**
 * 文 件 名:  LoginMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/20 0020
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.database.mapper;

import com.civil.aviation.human.database.entity.Employee;

/**
 * <系统登录Mapper>
 *
 * @author zping
 * @version 2018/3/20 0020
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface LoginMapper
{
	/**
	 * 用户系统登录
	 *
	 * @param employeeId
	 * @param password
	 * @return
	 */
	Employee login (String employeeId, String password);
}
