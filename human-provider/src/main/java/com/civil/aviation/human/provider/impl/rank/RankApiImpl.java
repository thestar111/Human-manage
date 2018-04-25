/**
 * 文 件 名:  RankApiImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.provider.impl.rank;

import com.civil.aviation.human.api.rank.RankApi;
import com.civil.aviation.human.api.rank.domain.RankVo;
import com.civil.aviation.human.api.rank.request.*;
import com.civil.aviation.human.api.rank.response.QryRankByIdResponse;
import com.civil.aviation.human.api.rank.response.QryRankConditionResponse;
import com.civil.aviation.human.common.core.annotation.Api;
import com.civil.aviation.human.common.core.domain.Result;
import com.civil.aviation.human.database.entity.Rank;
import com.civil.aviation.human.database.mapper.RankMapper;
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
 * <员工职级接口API实现>
 *
 * @author zping
 * @version 2018/3/22 0022
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Api
public class RankApiImpl implements RankApi
{

	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (RankApiImpl.class);

	@Autowired
	private RankMapper rankMapper;

	/**
	 * 添加
	 *
	 * @param request
	 * @param createRankRequest
	 * @return
	 */
	@Override
	public Result add (HttpServletRequest request, CreateRankRequest createRankRequest) throws Exception
	{
		if (null == createRankRequest)
		{
			return Result.fail ("illega params.");
		}

		RankVo rankVo = createRankRequest.getRank ();
		Rank rank = EntityMapperHandler.INSTANCE.voToRank (rankVo);

		int flag = rankMapper.add (rank);

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
	 * @param modifyRankRequest
	 * @return
	 */
	@Override
	public Result update (HttpServletRequest request, ModifyRankRequest modifyRankRequest) throws Exception
	{
		if (null == modifyRankRequest)
		{
			return Result.fail ("illega params.");
		}

		RankVo rankVo = modifyRankRequest.getRank ();
		Rank rank = EntityMapperHandler.INSTANCE.voToRank (rankVo);

		int flag = rankMapper.modify (rank);

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
	 * @param delRankRequest
	 * @return
	 */
	@Override
	public Result delete (HttpServletRequest request, DelRankRequest delRankRequest) throws Exception
	{
		if (null == delRankRequest || null == delRankRequest.getRankId ())
		{
			return Result.fail ("illega params.");
		}

		Integer rankId = delRankRequest.getRankId ();
		int flag = rankMapper.delete (rankId);

		if (flag > 0)
		{
			return new Result ();
		}
		else
		{
			return Result.fail ("delete failed");
		}
	}

	/**
	 * 查询
	 *
	 * @param request
	 * @param qryRankByIdRequest
	 * @return
	 */
	@Override
	public QryRankByIdResponse findById (HttpServletRequest request, QryRankByIdRequest qryRankByIdRequest)
			throws Exception
	{
		QryRankByIdResponse qryRankByIdResponse = null;
		if (null == qryRankByIdRequest || null == qryRankByIdRequest.getRankId ())
		{
			return (QryRankByIdResponse) Result.fail ("illega params.");
		}

		Integer rankId = qryRankByIdRequest.getRankId ();
		Rank rank = rankMapper.findById (rankId);
		if (null != rank)
		{
			qryRankByIdResponse = new QryRankByIdResponse ();
			RankVo rankVo = EntityMapperHandler.INSTANCE.rankToVo (rank);
			qryRankByIdResponse.setRank (rankVo);
			return qryRankByIdResponse;
		}
		else
		{
			return (QryRankByIdResponse) Result.success ("rank not exist.");
		}
	}

	/**
	 * 查询列表
	 *
	 * @param request
	 * @param qryRankConditionRequest
	 * @return
	 */
	@Override
	public QryRankConditionResponse queryConditionPage (HttpServletRequest request,
			QryRankConditionRequest qryRankConditionRequest) throws Exception
	{
		QryRankConditionResponse qryRankConditionResponse = new QryRankConditionResponse ();
		Map<String, Object> params = Maps.newHashMap ();

		if (! StringUtils.isEmpty (qryRankConditionRequest.getRankName ()))
		{
			params.put ("name", qryRankConditionRequest.getRankName ());
		}

		params.put ("pageIndex", qryRankConditionRequest.getPageIndex ());
		params.put ("pageSize", qryRankConditionRequest.getPageSize ());

		List<Rank> ranks = rankMapper.findByCondition (params);
		List<RankVo> rankVos = null;
		if (! CollectionUtils.isEmpty (ranks))
		{
			rankVos = Lists.newArrayList ();
			RankVo rankVo = null;
			for (Rank rank : ranks)
			{
				rankVo = EntityMapperHandler.INSTANCE.rankToVo (rank);
				rankVos.add (rankVo);
			}
			qryRankConditionResponse.setRanks (rankVos);
			qryRankConditionResponse.setCount (rankMapper.findCountByCondition (params));
			return qryRankConditionResponse;
		}
		else
		{
			qryRankConditionResponse.setRanks (rankVos);
			qryRankConditionResponse.setCount (0);
			return qryRankConditionResponse;
		}
	}
}
