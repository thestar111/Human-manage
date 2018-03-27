/**
 * 文 件 名:  UserApi
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.user;

import com.civil.aviation.human.api.user.request.*;
import com.civil.aviation.human.api.user.response.QryEmployeeByIdResponse;
import com.civil.aviation.human.api.user.response.QryEmployeeConditionResponse;
import com.civil.aviation.human.common.core.domain.Result;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * <用户API>
 *
 * @author zping
 * @version 2018/3/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Path ("/user")
public interface UserApi
{

	/**
	 * 用户注册接口
	 *
	 * @param request
	 * @return
	 */
	@POST
	@Path ("/regist")
	@Produces (MediaType.APPLICATION_JSON)
	Result regist (@Context HttpServletRequest request, CreateEmployeeRequest createEmployeeRequest);

	/**
	 * 用户修改接口
	 *
	 * @param request
	 * @return
	 */
	@POST
	@Path ("/modify")
	@Produces (MediaType.APPLICATION_JSON)
	Result modify (@Context HttpServletRequest request, ModifyEmployeeRequest modifyEmployeeRequest);

	/**
	 * 用户删除接口
	 *
	 * @param request
	 * @return
	 */
	@POST
	@Path ("/delete")
	@Produces (MediaType.APPLICATION_JSON)
	Result delete (@Context HttpServletRequest request, DelEmployeeRequest delEmployeeRequest);

	/**
	 * 用户查询接口
	 *
	 * @param request
	 * @return
	 */
	@POST
	@Path ("/findById")
	@Produces (MediaType.APPLICATION_JSON)
	QryEmployeeByIdResponse findById (@Context HttpServletRequest request,
			QryEmployeeByIdRequest qryEmployeeByIdRequest);

	/**
	 * 用户查询接口
	 *
	 * @param request
	 * @return
	 */
	@POST
	@Path ("/queryByCondition")
	@Produces (MediaType.APPLICATION_JSON)
	QryEmployeeConditionResponse queryByCondition (@Context HttpServletRequest request,
			QryEmployeeConditionRequest qryEmployeeConditionRequest);
}
