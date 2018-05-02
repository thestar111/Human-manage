/**
 * 文 件 名:  DepartmentApi
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.department;

import com.civil.aviation.human.api.department.request.CreateDepartmentRequest;
import com.civil.aviation.human.api.department.request.DelPartmentRequest;
import com.civil.aviation.human.api.department.request.ModifyDepartmentRequest;
import com.civil.aviation.human.api.department.request.QryDepartmentByIdRequest;
import com.civil.aviation.human.api.department.response.QryDepartmentByIdResponse;
import com.civil.aviation.human.api.department.response.QryDepartmentResponse;
import com.civil.aviation.human.common.core.domain.Result;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * <部门接口API>
 *
 * @author zping
 * @version 2018/3/22 0022
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Path ("/department")
public interface DepartmentApi
{
	/**
	 * 添加
	 *
	 * @param request
	 * @param createDepartmentRequest
	 * @return
	 */
	@Validated
	@POST
	@Path ("/add")
	@Produces (MediaType.APPLICATION_JSON)
	Result add (@Context HttpServletRequest request, CreateDepartmentRequest createDepartmentRequest) throws Exception;

	/**
	 * 修改
	 *
	 * @param request
	 * @param modifyDepartmentRequest
	 * @return
	 */
	@POST
	@Path ("/modify")
	@Produces (MediaType.APPLICATION_JSON)
	Result update (@Context HttpServletRequest request, ModifyDepartmentRequest modifyDepartmentRequest)
			throws Exception;

	/**
	 * 删除
	 *
	 * @param request
	 * @param delPartmentRequest
	 * @return
	 */
	@POST
	@Path ("/delete")
	@Produces (MediaType.APPLICATION_JSON)
	Result delete (@Context HttpServletRequest request, DelPartmentRequest delPartmentRequest) throws Exception;

	/**
	 * 查询
	 *
	 * @param request
	 * @param qryDepartmentByIdRequest
	 * @return
	 */
	@POST
	@Path ("/findById")
	@Produces (MediaType.APPLICATION_JSON)
	QryDepartmentByIdResponse findById (@Context HttpServletRequest request,
			QryDepartmentByIdRequest qryDepartmentByIdRequest) throws Exception;

	/**
	 * 查询列表
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@GET
	@Path ("/query")
	@Produces (MediaType.APPLICATION_JSON)
	QryDepartmentResponse queryConditionPage (@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws Exception;
}
