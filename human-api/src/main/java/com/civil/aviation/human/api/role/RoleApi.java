/**
 * 文 件 名:  RoleApi
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.role;

import com.civil.aviation.human.api.role.request.CreateRoleRequest;
import com.civil.aviation.human.api.role.request.DelRoleRequest;
import com.civil.aviation.human.api.role.request.ModifyRoleRequest;
import com.civil.aviation.human.api.role.request.QryRoleByIdRequest;
import com.civil.aviation.human.api.role.response.QryRoleByIdResponse;
import com.civil.aviation.human.api.user.request.CreateEmployeeRequest;
import com.civil.aviation.human.api.user.request.DelEmployeeRequest;
import com.civil.aviation.human.api.user.request.ModifyEmployeeRequest;
import com.civil.aviation.human.api.user.request.QryEmployeeByIdRequest;
import com.civil.aviation.human.api.user.response.QryEmployeeByIdResponse;
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
@Path ("/role")
public interface RoleApi
{
	/**
	 * 角色添加接口
	 *
	 * @param request
	 * @return
	 */
	@POST
	@Path ("/add")
	@Produces (MediaType.APPLICATION_JSON)
	Result add (@Context HttpServletRequest request, CreateRoleRequest createRoleRequest);

	/**
	 * 修改接口
	 *
	 * @param request
	 * @return
	 */
	@POST
	@Path ("/modify")
	@Produces (MediaType.APPLICATION_JSON)
	Result modify (@Context HttpServletRequest request, ModifyRoleRequest modifyRoleRequest);

	/**
	 * 删除接口
	 *
	 * @param request
	 * @return
	 */
	@POST
	@Path ("/delete")
	@Produces (MediaType.APPLICATION_JSON)
	Result delete (@Context HttpServletRequest request, DelRoleRequest delRoleRequest);

	/**
	 * 角色查询接口
	 *
	 * @param request
	 * @return
	 */
	@POST
	@Path ("/findById")
	@Produces (MediaType.APPLICATION_JSON)
	QryRoleByIdResponse findById (@Context HttpServletRequest request, QryRoleByIdRequest qryRoleByIdRequest);
}
