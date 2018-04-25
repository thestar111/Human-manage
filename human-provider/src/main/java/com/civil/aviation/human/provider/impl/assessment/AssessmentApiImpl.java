/**
 * 文 件 名:  AssessmentApiImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/2 0002
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.provider.impl.assessment;

import com.civil.aviation.human.api.assess.AssessmentApi;
import com.civil.aviation.human.api.assess.domain.AssessContentVo;
import com.civil.aviation.human.api.assess.domain.AssessGradeVo;
import com.civil.aviation.human.api.assess.domain.AssessTopicVo;
import com.civil.aviation.human.api.assess.request.*;
import com.civil.aviation.human.api.assess.response.AssessmentTopicResponse;
import com.civil.aviation.human.api.assess.response.QryAssessResultByEmployResponse;
import com.civil.aviation.human.api.assess.response.QryAssessTopicResponse;
import com.civil.aviation.human.common.core.annotation.Api;
import com.civil.aviation.human.common.core.cons.Constants;
import com.civil.aviation.human.common.core.domain.Result;
import com.civil.aviation.human.common.core.utils.SessionUtils;
import com.civil.aviation.human.database.entity.AssessContent;
import com.civil.aviation.human.database.entity.AssessResult;
import com.civil.aviation.human.database.entity.AssessTopic;
import com.civil.aviation.human.database.mapper.AssessmentMapper;
import com.civil.aviation.human.database.mapper.EmployeeMappper;
import com.civil.aviation.human.provider.mapper.EntityMapperHandler;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * <员工考核主题接口实现>
 *
 * @author zping
 * @version 2018/4/2 0002
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Api
public class AssessmentApiImpl implements AssessmentApi
{

	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (AssessmentApiImpl.class);

	@Autowired
	private AssessmentMapper assessmentMapper;

	@Autowired
	private EmployeeMappper employeeMappper;

	/**
	 * 添加考核主题
	 *
	 * @param request
	 * @param createAssessmentTopicRequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public Result addAssessmentTopic (HttpServletRequest request,
			CreateAssessmentTopicRequest createAssessmentTopicRequest) throws Exception
	{

		if (null == createAssessmentTopicRequest)
		{
			return Result.fail ("illega params is null.");
		}

		if (null == createAssessmentTopicRequest.getAssessTopic ())
		{
			return Result.fail ("illega params is null.");
		}

		if (null == createAssessmentTopicRequest.getAssessContents () || CollectionUtils
				.isEmpty (createAssessmentTopicRequest.getAssessContents ()))
		{
			return Result.fail ("illega params is null.");
		}

		AssessTopic assessTopic = EntityMapperHandler.INSTANCE
				.voTOAssessTopic (createAssessmentTopicRequest.getAssessTopic ());

		//考核标准
		List<AssessContent> assessContents = Lists.newArrayList ();
		AssessContent assessContent = null;
		for (AssessContentVo assessContentVo : createAssessmentTopicRequest.getAssessContents ())
		{
			assessContent = EntityMapperHandler.INSTANCE.voToAssessContent (assessContentVo);
			assessContents.add (assessContent);
		}

		int flag = assessmentMapper.addAssessTopic (assessTopic);

		if (flag > 0)
		{
			if (assessmentMapper.addAssessContent (assessContents) > 0)
			{
				return Result.success ("add assess topic success.");
			}
			else
			{
				return Result.fail ("add assess topic failed.");
			}
		}
		else
		{
			return Result.fail ("add assess topic failed.");
		}
	}

	/**
	 * 修改考核主题
	 *
	 * @param request
	 * @param modifyAssessmentRequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public Result modifyAssessmentTopic (HttpServletRequest request, ModifyAssessmentRequest modifyAssessmentRequest)
			throws Exception
	{
		if (null == modifyAssessmentRequest)
		{
			return Result.fail ("illega params is null.");
		}

		if (null == modifyAssessmentRequest.getAssessTopic ())
		{
			return Result.fail ("illega params is null.");
		}

		if (null == modifyAssessmentRequest.getAssessContents () || CollectionUtils
				.isEmpty (modifyAssessmentRequest.getAssessContents ()))
		{
			return Result.fail ("illega params is null.");
		}

		AssessTopic assessTopic = EntityMapperHandler.INSTANCE
				.voTOAssessTopic (modifyAssessmentRequest.getAssessTopic ());

		//考核标准
		List<AssessContent> assessContents = Lists.newArrayList ();
		AssessContent assessContent = null;
		for (AssessContentVo assessContentVo : modifyAssessmentRequest.getAssessContents ())
		{
			assessContent = EntityMapperHandler.INSTANCE.voToAssessContent (assessContentVo);
			assessContents.add (assessContent);
		}

		//先删除考核标准
		int flag = assessmentMapper.deleteAssessContent (assessTopic.getId ());

		if (flag > 0)
		{
			if (assessmentMapper.modifyAssessTopic (assessTopic) > 0)
			{
				if (assessmentMapper.addAssessContent (assessContents) > 0)
				{
					return Result.success ("modify assess topic success.");
				}
				else
				{
					return Result.fail ("modify assess topic failed.");
				}
			}
			else
			{
				return Result.fail ("modify assess topic failed.");
			}
		}
		else
		{
			return Result.fail ("modify assess topic failed.");
		}
	}

	/**
	 * 添加考核成绩
	 *
	 * @param request
	 * @param createAssessResultRequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public Result addAssessResult (HttpServletRequest request, CreateAssessResultRequest createAssessResultRequest)
			throws Exception
	{
		if (null == createAssessResultRequest || null == createAssessResultRequest.getAssessResult ())
		{
			return Result.fail ("illega params is null.");
		}

		if (null == assessmentMapper.queryAssessResult (createAssessResultRequest.getAssessResult ().getEmployeeId (),
				createAssessResultRequest.getAssessResult ().getDiscussant ()))
		{
			AssessResult assessResult = EntityMapperHandler.INSTANCE
					.voToAssessResult (createAssessResultRequest.getAssessResult ());
			assessResult.setDiscussant ((String) SessionUtils.getValue (SessionUtils.EMPLOYEE_ID_SESSION_KEY));
			int flag = assessmentMapper.addAssessResult (assessResult);

			if (flag > 0)
			{
				return Result.success ("add assess result success.");
			}
			else
			{
				return Result.fail ("add assess result failed.");
			}
		}
		else
		{
			return Result.fail ("add assess result failed, You had assess him.");
		}
	}

	/**
	 * 查询当前生效的考核主题
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@Override
	public AssessmentTopicResponse qryEffectiveAssessTopic (HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		AssessmentTopicResponse result = new AssessmentTopicResponse ();

		//查询当前生效的考核主题
		AssessTopic assessTopic = assessmentMapper.qryEffectiveAssessTopic ();

		//为空，则说明不存在
		if (null == assessTopic)
		{
			result.setResultCode ("0");
			result.setResultMessage ("It is not time for assessment.");
			return result;
		}
		//查询考核标准
		List<AssessContent> assessContents = assessmentMapper.qryAssessContentByTopicId (assessTopic.getId ());
		List<AssessContentVo> assessContentVos = null;
		AssessContentVo assessContentVo = null;
		if (! CollectionUtils.isEmpty (assessContents))
		{
			assessContentVos = Lists.newArrayList ();
			for (AssessContent assessContent : assessContents)
			{
				assessContentVo = EntityMapperHandler.INSTANCE.assessContentToVo (assessContent);
				assessContentVos.add (assessContentVo);
			}
		}

		AssessTopicVo assessTopicVo = EntityMapperHandler.INSTANCE.assessTopicToVo (assessTopic);

		result.setResultMessage ("query success.");
		result.setResultCode (Constants.ResultCode.SUCCESS);
		result.setAssessContents (assessContentVos);
		result.setAssessTopic (assessTopicVo);
		return result;
	}

	/**
	 * 根据条件查询考核主题信息
	 *
	 * @param request
	 * @param qryAssessTopicRequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public QryAssessTopicResponse qryAssessTopicByCondition (HttpServletRequest request,
			QryAssessTopicRequest qryAssessTopicRequest) throws Exception
	{
		QryAssessTopicResponse qryAssessTopicResponse = new QryAssessTopicResponse ();
		Map<String, Object> params = Maps.newHashMap ();
		if (null != qryAssessTopicRequest.getStatus ())
		{
			params.put ("status", qryAssessTopicRequest.getStatus ());
		}

		if (! StringUtils.isEmpty (qryAssessTopicRequest.getStartTime ()))
		{
			params.put ("startTime", qryAssessTopicRequest.getStartTime ());
		}

		if (! StringUtils.isEmpty (qryAssessTopicRequest.getEndTime ()))
		{
			params.put ("endTime", qryAssessTopicRequest.getEndTime ());
		}

		params.put ("pageIndex", qryAssessTopicRequest.getPageIndex ());
		params.put ("pageSize", qryAssessTopicRequest.getPageSize ());

		//查询考核标题信息
		List<AssessTopic> assessTopics = assessmentMapper.qryAssessTopicByCondition (params);
		List<AssessTopicVo> assessTopicVos = null;
		AssessTopicVo assessTopicVo = null;
		if (! CollectionUtils.isEmpty (assessTopics))
		{
			assessTopicVos = Lists.newArrayList ();
			for (AssessTopic assessTopic : assessTopics)
			{
				assessTopicVo = EntityMapperHandler.INSTANCE.assessTopicToVo (assessTopic);
				assessTopicVos.add (assessTopicVo);
			}
		}
		qryAssessTopicResponse.setAssessTopics (assessTopicVos);
		qryAssessTopicResponse.setCount (assessmentMapper.qryAssessTopicCountByCondition (params));
		return qryAssessTopicResponse;
	}

	/**
	 * 根据员工编号查询去年的考核成绩
	 *
	 * @param request
	 * @param qryAssessResultByEmployRequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public QryAssessResultByEmployResponse qryAssessResultByEmployee (HttpServletRequest request,
			QryAssessResultByEmployRequest qryAssessResultByEmployRequest) throws Exception
	{
		QryAssessResultByEmployResponse qryAssessResultByEmployResponse = new QryAssessResultByEmployResponse ();
		if (null == qryAssessResultByEmployRequest || StringUtils
				.isEmpty (qryAssessResultByEmployRequest.getEmployeeId ()))
		{
			return (QryAssessResultByEmployResponse) Result.fail ("illega params.");
		}

		AssessGradeVo assessGradeVo = new AssessGradeVo ();
		//查询自评
		AssessResult assessResult = assessmentMapper
				.queryAssessResultBySelf (qryAssessResultByEmployRequest.getEmployeeId ());
		//自评分数
		Double score = assessResult.getScore () * assessResult.getWeight () / 100;
		assessGradeVo.setScore (score);

		//上级分数
		List<AssessResult> higherAssessResult = assessmentMapper
				.queryAssessResultByEmployee (qryAssessResultByEmployRequest.getEmployeeId (), 60);
		if (! CollectionUtils.isEmpty (higherAssessResult))
		{
			double higherTotal = 0;
			for (AssessResult result : higherAssessResult)
			{
				higherTotal += result.getScore ();
			}
			Double higherScore = higherTotal / higherAssessResult.size () * 60 / 100;
			assessGradeVo.setHigherUpScore (higherScore);
		}

		//下级分数
		List<AssessResult> lowerAssessResult = assessmentMapper
				.queryAssessResultByEmployee (qryAssessResultByEmployRequest.getEmployeeId (), 20);
		if (! CollectionUtils.isEmpty (lowerAssessResult))
		{
			double lowerTotal = 0;
			for (AssessResult result : lowerAssessResult)
			{
				lowerTotal += result.getScore ();
			}
			Double lowerScore = lowerTotal / lowerAssessResult.size () * 20 / 100;
			assessGradeVo.setLowerUpScore (lowerScore);
		}

		//同级分数
		List<AssessResult> visAssessResult = assessmentMapper
				.queryAssessResultByEmployee (qryAssessResultByEmployRequest.getEmployeeId (), 10);
		if (! CollectionUtils.isEmpty (visAssessResult))
		{
			double visTotal = 0;
			for (AssessResult result : visAssessResult)
			{
				visTotal += result.getScore ();
			}
			Double visScore = visTotal / visAssessResult.size () * 10 / 100;
			assessGradeVo.setVis_a_vis_score (visScore);
		}

		assessGradeVo.setEmployeeId (qryAssessResultByEmployRequest.getEmployeeId ());
		assessGradeVo.setTime (assessResult.getTime ().substring (0, 4));
		assessGradeVo.setTopic (assessResult.getTopic ());
		assessGradeVo.setEmployeeName (
				employeeMappper.queryEmployById (qryAssessResultByEmployRequest.getEmployeeId ()).getName ());
		qryAssessResultByEmployResponse.setAssessGrade (assessGradeVo);
		return qryAssessResultByEmployResponse;
	}

	/**
	 * 删除考核主题
	 *
	 * @param request
	 * @param deleteAssessTopicRequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public Result deleteAssessTopic (HttpServletRequest request, DeleteAssessTopicRequest deleteAssessTopicRequest)
			throws Exception
	{
		if (StringUtils.isEmpty (deleteAssessTopicRequest.getAssessTopicId ()))
		{
			return Result.fail ("assess topic id is null.");
		}

		int flag = assessmentMapper.deleteAssessTopic (deleteAssessTopicRequest.getAssessTopicId ());

		if (flag > 0)
		{
			if (assessmentMapper.deleteAssessContent (deleteAssessTopicRequest.getAssessTopicId ()) > 0)
			{
				return Result.success ("delete assess result success.");
			}
			else
			{
				return Result.fail ("delete assess result failed.");
			}
		}
		else
		{
			return Result.fail ("delete assess result failed.");
		}
	}
}
