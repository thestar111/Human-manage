/**
 * 文 件 名:  MenuApi
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.menu;

import com.civil.aviation.human.api.department.request.*;
import com.civil.aviation.human.api.department.response.QryDepartmentResponse;
import com.civil.aviation.human.api.menu.request.*;
import com.civil.aviation.human.api.menu.response.QryMenuByIdResponse;
import com.civil.aviation.human.api.menu.response.QryMenuConditionResponse;
import com.civil.aviation.human.common.core.domain.Result;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/22 0022
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Path ("/menu")
public interface MenuApi
{
	/**
	 * 添加
	 *
	 * @param request
	 * @param createMenuRequest
	 * @return
	 */
	@POST
	@Path ("/add")
	@Produces (MediaType.APPLICATION_JSON)
	Result add (@Context HttpServletRequest request, CreateMenuRequest createMenuRequest) throws Exception;

	/**
	 * 修改
	 *
	 * @param request
	 * @param modifyMenuRequest
	 * @return
	 */
	@POST
	@Path ("/modify")
	@Produces (MediaType.APPLICATION_JSON)
	Result update (@Context HttpServletRequest request, ModifyMenuRequest modifyMenuRequest) throws Exception;

	/**
	 * 删除
	 *
	 * @param request
	 * @param delMenuRequest
	 * @return
	 */
	@POST
	@Path ("/delete")
	@Produces (MediaType.APPLICATION_JSON)
	Result delete (@Context HttpServletRequest request, DelMenuRequest delMenuRequest) throws Exception;

	/**
	 * 查询
	 *
	 * @param request
	 * @param qryMenuByIdRequest
	 * @return
	 */
	@POST
	@Path ("/findById")
	@Produces (MediaType.APPLICATION_JSON)
	QryMenuByIdResponse findById (@Context HttpServletRequest request, QryMenuByIdRequest qryMenuByIdRequest) throws Exception;

	/**
	 * 查询列表
	 *
	 * @param request
	 * @param qryMenuConditionRequest
	 * @return
	 */
	@POST
	@Path ("/query")
	@Produces (MediaType.APPLICATION_JSON)
	QryMenuConditionResponse queryConditionPage (@Context HttpServletRequest request,
			QryMenuConditionRequest qryMenuConditionRequest) throws Exception;
}
