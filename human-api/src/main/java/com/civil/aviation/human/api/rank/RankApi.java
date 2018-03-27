/**
 * 文 件 名:  rank
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.rank;

import com.civil.aviation.human.api.rank.request.*;
import com.civil.aviation.human.api.rank.response.QryRankByIdResponse;
import com.civil.aviation.human.api.rank.response.QryRankConditionResponse;
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
@Path ("/rank")
public interface RankApi
{
	/**
	 * 添加
	 *
	 * @param request
	 * @param createRankRequest
	 * @return
	 */
	@POST
	@Path ("/add")
	@Produces (MediaType.APPLICATION_JSON)
	Result add (@Context HttpServletRequest request, CreateRankRequest createRankRequest);

	/**
	 * 修改
	 *
	 * @param request
	 * @param modifyRankRequest
	 * @return
	 */
	@POST
	@Path ("/modify")
	@Produces (MediaType.APPLICATION_JSON)
	Result update (@Context HttpServletRequest request, ModifyRankRequest modifyRankRequest);

	/**
	 * 删除
	 *
	 * @param request
	 * @param delRankRequest
	 * @return
	 */
	@POST
	@Path ("/delete")
	@Produces (MediaType.APPLICATION_JSON)
	Result delete (@Context HttpServletRequest request, DelRankRequest delRankRequest);

	/**
	 * 查询
	 *
	 * @param request
	 * @param qryRankByIdRequest
	 * @return
	 */
	@POST
	@Path ("/findById")
	@Produces (MediaType.APPLICATION_JSON)
	QryRankByIdResponse findById (@Context HttpServletRequest request, QryRankByIdRequest qryRankByIdRequest);

	/**
	 * 查询列表
	 *
	 * @param request
	 * @param qryRankConditionRequest
	 * @return
	 */
	@POST
	@Path ("/query")
	@Produces (MediaType.APPLICATION_JSON)
	QryRankConditionResponse queryConditionPage (@Context HttpServletRequest request,
			QryRankConditionRequest qryRankConditionRequest);
}
