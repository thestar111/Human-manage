/**
 * 文 件 名:  JobApiImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.provider.impl.job;

import com.civil.aviation.human.api.job.JobApi;
import com.civil.aviation.human.api.job.domain.JobVo;
import com.civil.aviation.human.api.job.request.*;
import com.civil.aviation.human.api.job.response.QryJobByIdResponse;
import com.civil.aviation.human.api.job.response.QryJobConditionResponse;
import com.civil.aviation.human.common.core.annotation.Api;
import com.civil.aviation.human.common.core.domain.Result;
import com.civil.aviation.human.database.entity.Job;
import com.civil.aviation.human.database.mapper.JobMapper;
import com.civil.aviation.human.provider.mapper.EntityMapperHandler;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/22 0022
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Api
public class JobApiImpl implements JobApi
{
	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (JobApiImpl.class);

	@Autowired
	private JobMapper jobMapper;

	/**
	 * 添加
	 *
	 * @param request
	 * @param createJobRequest
	 * @return
	 */
	@Override
	public Result add (HttpServletRequest request, CreateJobRequest createJobRequest) throws Exception
	{
		if (null == createJobRequest)
		{
			return Result.fail ("illage params");
		}
		Job job = new Job ();
		EntityMapperHandler.INSTANCE.voToJob (job, createJobRequest.getJob ());
		int flag = jobMapper.add (job);

		if (flag > 0)
		{
			return new Result ();
		}
		else
		{
			return Result.fail ("insert failed");
		}
	}

	/**
	 * 修改
	 *
	 * @param request
	 * @param modifyJobRequest
	 * @return
	 */
	@Override
	public Result update (HttpServletRequest request, ModifyJobRequest modifyJobRequest) throws Exception
	{
		if (null == modifyJobRequest)
		{
			return Result.fail ("illage params");
		}

		Job job = new Job ();
		EntityMapperHandler.INSTANCE.voToJob (job, modifyJobRequest.getJob ());

		int flag = jobMapper.modify (job);

		if (flag > 0)
		{
			return new Result ();
		}
		else
		{
			return Result.fail ("modify failed");
		}
	}

	/**
	 * 删除
	 *
	 * @param request
	 * @param delJobRequest
	 * @return
	 */
	@Override
	public Result delete (HttpServletRequest request, DelJobRequest delJobRequest) throws Exception
	{
		if (null == delJobRequest.getJobId ())
		{
			Result.fail ("department id is null");
		}

		int flag = jobMapper.delete (delJobRequest.getJobId ());

		if (flag > 0)
		{
			return new Result ();
		}
		else
		{
			return Result.fail ("delete job failed.");
		}
	}

	/**
	 * 查询
	 *
	 * @param request
	 * @param qryJobByIdRequest
	 * @return
	 */
	@Override
	public QryJobByIdResponse findById (HttpServletRequest request, QryJobByIdRequest qryJobByIdRequest)
			throws Exception

	{
		QryJobByIdResponse qryJobByIdResponse = null;

		if (null == qryJobByIdRequest.getJobId ())
		{
			return (QryJobByIdResponse) Result.fail ("job id is null");
		}

		Job job = jobMapper.findById (qryJobByIdRequest.getJobId ());

		if (null != job)
		{
			JobVo jobVo = EntityMapperHandler.INSTANCE.jobTOVo (job);
			qryJobByIdResponse = new QryJobByIdResponse ();
			qryJobByIdResponse.setJob (jobVo);
			return qryJobByIdResponse;
		}
		else
		{
			return (QryJobByIdResponse) Result.fail ("job not exist");
		}
	}

	/**
	 * 查询列表
	 *
	 * @param request
	 * @param qryJobConditionRequest
	 * @return
	 */
	@Override
	public QryJobConditionResponse queryConditionPage (HttpServletRequest request,
			QryJobConditionRequest qryJobConditionRequest) throws Exception
	{
		QryJobConditionResponse qryJobConditionResponse = new QryJobConditionResponse ();
		Map<String, Object> params = Maps.newHashMap ();

		if (! StringUtils.isEmpty (qryJobConditionRequest.getJobName ()))
		{
			params.put ("name", qryJobConditionRequest.getJobName ());
		}

		params.put ("pageIndex", qryJobConditionRequest.getPageIndex ());
		params.put ("pageSize", qryJobConditionRequest.getPageSize ());

		List<Job> jobs = jobMapper.findByCondition (params);
		List<JobVo> jobVos = null;
		if (! CollectionUtils.isEmpty (jobs))
		{
			jobVos = Lists.newArrayList ();
			JobVo jobVo = null;
			for (Job job : jobs)
			{
				jobVo = EntityMapperHandler.INSTANCE.jobTOVo (job);
				jobVos.add (jobVo);
			}
			qryJobConditionResponse.setJobs (jobVos);
			qryJobConditionResponse.setCount (jobMapper.findCountByCondition (params));
			return qryJobConditionResponse;
		}
		else
		{
			qryJobConditionResponse.setJobs (jobVos);
			qryJobConditionResponse.setCount (0);
			return qryJobConditionResponse;
		}
	}
}
