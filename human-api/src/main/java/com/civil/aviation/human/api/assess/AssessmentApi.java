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
import com.civil.aviation.human.api.assess.response.*;
import com.civil.aviation.human.common.core.domain.Result;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
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
	 * 根据编号查询考核主题
	 *
	 * @param request
	 * @param qryAssessTopicByIdRequest
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path ("/qryAssessmentTopicById")
	@Produces (MediaType.APPLICATION_JSON)
	QryAssessTopicByIdResponse queryAssessmentTopicById (@Context HttpServletRequest request, QryAssessTopicByIdRequest qryAssessTopicByIdRequest)
			throws Exception;

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
	 * 添加考核内容信息
	 *
	 * @param request
	 * @param createAssessContentRequest
	 * @return
	 */
	@POST
	@Path ("/addAssessContent")
	@Produces (MediaType.APPLICATION_JSON)
	Result addAssessContent (@Context HttpServletRequest request, CreateAssessContentRequest createAssessContentRequest)
			throws Exception;

	/**
	 * 修改考核内容信息
	 *
	 * @param request
	 * @param modifyAssessContentRequest
	 * @return
	 */
	@POST
	@Path ("/modifyAssessContent")
	@Produces (MediaType.APPLICATION_JSON)
	Result modifyAssessContent (@Context HttpServletRequest request,
			ModifyAssessContentRequest modifyAssessContentRequest) throws Exception;

	/**
	 * 删除考核内容信息
	 *
	 * @param request
	 * @param deleteAssessContentRequest
	 * @return
	 */
	@POST
	@Path ("/deleteAssessContent")
	@Produces (MediaType.APPLICATION_JSON)
	Result deleteAssessContent (@Context HttpServletRequest request,
			DeleteAssessContentRequest deleteAssessContentRequest) throws Exception;

	/**
	 * 查询考核内容列表信息
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@GET
	@Path ("/queryAssessContentList")
	@Produces (MediaType.APPLICATION_JSON)
	QryAssessContentListResponse queryAssessContentList (@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws Exception;

	/**
	 * 查询考核内容列表信息
	 *
	 * @param request
	 * @param queryAssessContentRequest
	 * @return
	 */
	@POST
	@Path ("/queryAssessContentById")
	@Produces (MediaType.APPLICATION_JSON)
	QryAssessContentResponse queryAssessContentById (@Context HttpServletRequest request,
			QueryAssessContentRequest queryAssessContentRequest) throws Exception;

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
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path ("/query/condition")
	@Produces (MediaType.APPLICATION_JSON)
	QryAssessTopicResponse qryAssessTopicByCondition (@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws Exception;

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
	 * 查询员工考核成绩列表
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path ("/query/assessResult")
	@Produces (MediaType.APPLICATION_JSON)
    QryAssessResultsResponse qryAssessResults (@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws Exception;

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

	/**
	 * 添加考核分类
	 *
	 * @param request
	 * @param createAssessCatalogRequest
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path ("/assessCatalog/add")
	@Produces (MediaType.APPLICATION_JSON)
	Result addAssessCatalog (@Context HttpServletRequest request, CreateAssessCatalogRequest createAssessCatalogRequest)
			throws Exception;

	/**
	 * 修改考核分类
	 *
	 * @param request
	 * @param modifyAssessCatalogRequest
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path ("/assessCatalog/modify")
	@Produces (MediaType.APPLICATION_JSON)
	Result modifyAssessCatalog (@Context HttpServletRequest request,
			ModifyAssessCatalogRequest modifyAssessCatalogRequest) throws Exception;

	/**
	 * 删除考核分类
	 *
	 * @param request
	 * @param deleteAssessCatalogRequest
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path ("/assessCatalog/delete")
	@Produces (MediaType.APPLICATION_JSON)
	Result deleteAssessCatalog (@Context HttpServletRequest request,
			DeleteAssessCatalogRequest deleteAssessCatalogRequest) throws Exception;

	/**
	 * 查询考核分类信息
	 *
	 * @param queryAssessCatalogRequest
	 * @return
	 * @throws Exception
	 */
	@POST
	@Path ("/assessCatalog/queryById")
	@Produces (MediaType.APPLICATION_JSON)
	QryAssessCatalogByIdResponse queryAssessCatalogList (@Context HttpServletRequest request,
			QueryAssessCatalogRequest queryAssessCatalogRequest) throws Exception;

	/**
	 * 查询考核分类信息
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path ("/assessCatalog/queryList")
	@Produces (MediaType.APPLICATION_JSON)
	QryAssessCatalogResponse queryAssessCatalogList (@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws Exception;
}
