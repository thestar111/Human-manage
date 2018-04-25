/**
 * 文 件 名:  AssessmentApi
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/30 0030
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.assess;

import com.civil.aviation.human.api.assess.request.*;
import com.civil.aviation.human.api.assess.response.AssessmentTopicResponse;
import com.civil.aviation.human.api.assess.response.QryAssessResultByEmployResponse;
import com.civil.aviation.human.api.assess.response.QryAssessTopicResponse;
import com.civil.aviation.human.common.core.domain.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * <人事考核核心API>
 *
 * @author zping
 * @version 2018/3/30 0030
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Path ("/assessment")
public interface AssessmentApi
{

	/**
	 * 添加考核主题
	 *
	 * @param request
	 * @param createAssessmentTopicRequest
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path ("/add")
	@Produces (MediaType.APPLICATION_JSON)
	Result addAssessmentTopic (@Context HttpServletRequest request,
			CreateAssessmentTopicRequest createAssessmentTopicRequest) throws Exception;

	/**
	 * 修改考核主题
	 *
	 * @param request
	 * @param modifyAssessmentRequest
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path ("/modify")
	@Produces (MediaType.APPLICATION_JSON)
	Result modifyAssessmentTopic (@Context HttpServletRequest request, ModifyAssessmentRequest modifyAssessmentRequest)
			throws Exception;

	/**
	 * 添加考核成绩
	 *
	 * @param request
	 * @param createAssessResultRequest
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path ("/result/add")
	@Produces (MediaType.APPLICATION_JSON)
	Result addAssessResult (@Context HttpServletRequest request, CreateAssessResultRequest createAssessResultRequest)
			throws Exception;

	/**
	 * 查询当前生效的考核主题
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@POST
	@Path ("/query/effective")
	@Produces (MediaType.APPLICATION_JSON)
	AssessmentTopicResponse qryEffectiveAssessTopic (@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws Exception;

	/**
	 * 根据条件查询考核主题信息
	 *
	 * @param request
	 * @param qryAssessTopicRequest
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path ("/query/condition")
	@Produces (MediaType.APPLICATION_JSON)
	QryAssessTopicResponse qryAssessTopicByCondition (@Context HttpServletRequest request,
			QryAssessTopicRequest qryAssessTopicRequest) throws Exception;

	/**
	 * 根据员工编号查询去年的考核成绩
	 *
	 * @param request
	 * @param qryAssessResultByEmployRequest
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path ("/query/employee")
	@Produces (MediaType.APPLICATION_JSON)
	QryAssessResultByEmployResponse qryAssessResultByEmployee (@Context HttpServletRequest request,
			QryAssessResultByEmployRequest qryAssessResultByEmployRequest) throws Exception;

	/**
	 * 删除考核主题
	 *
	 * @param request
	 * @param deleteAssessTopicRequest
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path ("/delete")
	@Produces (MediaType.APPLICATION_JSON)
	Result deleteAssessTopic (@Context HttpServletRequest request, DeleteAssessTopicRequest deleteAssessTopicRequest)
			throws Exception;
}