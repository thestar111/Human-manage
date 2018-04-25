/**
 * 文 件 名:  PermsionApi
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.permsion;

import com.civil.aviation.human.api.permsion.request.CreatePermsionRequest;
import com.civil.aviation.human.api.permsion.request.DelPermsionRequest;
import com.civil.aviation.human.api.permsion.request.ModifyPermsionRequest;
import com.civil.aviation.human.api.permsion.request.QryPermsionByIdRequest;
import com.civil.aviation.human.api.permsion.response.QryPermsionByIdResponse;
import com.civil.aviation.human.common.core.domain.Result;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * <用户权限接口API>
 *
 * @author zping
 * @version 2018/3/22 0022
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Path ("/permsion")
public interface PermsionApi
{
	/**
	 * 添加
	 *
	 * @param request
	 * @param createPermsionRequest
	 * @return
	 */
	@POST
	@Path ("/add")
	@Produces (MediaType.APPLICATION_JSON)
	Result add (@Context HttpServletRequest request, CreatePermsionRequest createPermsionRequest) throws Exception;

	/**
	 * 修改
	 *
	 * @param request
	 * @param modifyPermsionRequest
	 * @return
	 */
	@POST
	@Path ("/modify")
	@Produces (MediaType.APPLICATION_JSON)
	Result update (@Context HttpServletRequest request, ModifyPermsionRequest modifyPermsionRequest) throws Exception;

	/**
	 * 删除
	 *
	 * @param request
	 * @param delPermsionRequest
	 * @return
	 */
	@POST
	@Path ("/delete")
	@Produces (MediaType.APPLICATION_JSON)
	Result delete (@Context HttpServletRequest request, DelPermsionRequest delPermsionRequest) throws Exception;

	/**
	 * 查询
	 *
	 * @param request
	 * @param qryPermsionByIdRequest
	 * @return
	 */
	@POST
	@Path ("/findById")
	@Produces (MediaType.APPLICATION_JSON)
	QryPermsionByIdResponse findById (@Context HttpServletRequest request,
			QryPermsionByIdRequest qryPermsionByIdRequest) throws Exception;
}
