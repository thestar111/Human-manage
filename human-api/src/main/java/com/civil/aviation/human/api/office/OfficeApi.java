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
package com.civil.aviation.human.api.office;

import com.civil.aviation.human.api.office.request.*;
import com.civil.aviation.human.api.office.response.QryOfficeByIdResponse;
import com.civil.aviation.human.api.office.response.QryOfficeResponse;
import com.civil.aviation.human.common.core.domain.Result;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * <科室接口API>
 *
 * @author zping
 * @version 2018/3/22 0022
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Path ("/office")
public interface OfficeApi
{
	/**
	 * 添加
	 *
	 * @param request
	 * @param createOfficeRequest
	 * @return
	 */
	@Validated
	@POST
	@Path ("/add")
	@Produces (MediaType.APPLICATION_JSON)
	Result add(@Context HttpServletRequest request, CreateOfficeRequest createOfficeRequest) throws Exception;

	/**
	 * 修改
	 *
	 * @param request
	 * @param modifyOfficeRequest
	 * @return
	 */
	@POST
	@Path ("/modify")
	@Produces (MediaType.APPLICATION_JSON)
	Result update(@Context HttpServletRequest request, ModifyOfficeRequest modifyOfficeRequest)
			throws Exception;

	/**
	 * 删除
	 *
	 * @param request
	 * @param delOfficeRequest
	 * @return
	 */
	@POST
	@Path ("/delete")
	@Produces (MediaType.APPLICATION_JSON)
	Result delete(@Context HttpServletRequest request, DelOfficeRequest delOfficeRequest) throws Exception;

	/**
	 * 查询
	 *
	 * @param request
	 * @param qryOfficeByIdRequest
	 * @return
	 */
	@POST
	@Path ("/findById")
	@Produces (MediaType.APPLICATION_JSON)
	QryOfficeByIdResponse findById(@Context HttpServletRequest request,
								   QryOfficeByIdRequest qryOfficeByIdRequest) throws Exception;

	/**
	 * 查询列表
	 *
	 * @param request
	 * @param qryOfficeRequest
	 * @return
	 */
	@POST
	@Path ("/query")
	@Produces (MediaType.APPLICATION_JSON)
	QryOfficeResponse queryConditionPage(@Context HttpServletRequest request,
										 QryOfficeRequest qryOfficeRequest) throws Exception;
}
