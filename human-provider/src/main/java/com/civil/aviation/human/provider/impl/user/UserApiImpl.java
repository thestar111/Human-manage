/**
 * 文 件 名:  UserApiImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/20 0020
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.provider.impl.user;

import com.civil.aviation.human.api.user.UserApi;
import com.civil.aviation.human.api.user.request.*;
import com.civil.aviation.human.api.user.response.QryEmployeeByIdResponse;
import com.civil.aviation.human.api.user.response.QryEmployeeConditionResponse;
import com.civil.aviation.human.common.core.annotation.Api;
import com.civil.aviation.human.common.core.cons.Constants;
import com.civil.aviation.human.common.core.domain.Result;
import com.civil.aviation.human.common.core.exception.HumanException;
import com.civil.aviation.human.database.entity.Employee;
import com.civil.aviation.human.database.mapper.EmployeeMappper;
import com.civil.aviation.human.provider.mapper.EntityMapperHandler;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/20 0020
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Api
public class UserApiImpl implements UserApi
{

	@Autowired
	private EmployeeMappper employeeMappper;

	/**
	 * 用户注册接口
	 *
	 * @param request
	 * @return
	 */
	@Override
	public Result regist (HttpServletRequest request, CreateEmployeeRequest createEmployeeRequest)
	{
		if (null == createEmployeeRequest)
		{
			throw new HumanException (Constants.ResultCode.FAILED, "Illega Parameters");
		}
		Employee employee = EntityMapperHandler.INSTANCE.employeeToEntity (createEmployeeRequest.getEmployee ());

		try
		{
			int flag = employeeMappper.add (employee);
			System.out.println (flag);
		}
		catch (SQLException e)
		{
			e.printStackTrace ();
		}
		return null;
	}

	/**
	 * 用户修改接口
	 *
	 * @param request
	 * @param modifyEmployeeRequest
	 * @return
	 */
	@Override
	public Result modify (HttpServletRequest request, ModifyEmployeeRequest modifyEmployeeRequest)
	{
		return null;
	}

	/**
	 * 用户删除接口
	 *
	 * @param request
	 * @param delEmployeeRequest
	 * @return
	 */
	@Override
	public Result delete (HttpServletRequest request, DelEmployeeRequest delEmployeeRequest)
	{
		return null;
	}

	/**
	 * 用户查询接口
	 *
	 * @param request
	 * @param qryEmployeeByIdRequest
	 * @return
	 */
	@Override
	public QryEmployeeByIdResponse findById (HttpServletRequest request, QryEmployeeByIdRequest qryEmployeeByIdRequest)
	{
		return null;
	}

	/**
	 * 用户查询接口
	 *
	 * @param request
	 * @param qryEmployeeConditionRequest
	 * @return
	 */
	@Override
	public QryEmployeeConditionResponse queryByCondition (HttpServletRequest request,
			QryEmployeeConditionRequest qryEmployeeConditionRequest)
	{
		return null;
	}
}
