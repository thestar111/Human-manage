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
import com.civil.aviation.human.api.rank.request.*;
import com.civil.aviation.human.api.rank.response.QryRankByIdResponse;
import com.civil.aviation.human.api.rank.response.QryRankConditionResponse;
import com.civil.aviation.human.common.core.annotation.Api;
import com.civil.aviation.human.common.core.domain.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * <一句话功能简述> <功能详细描述>
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
	 * 添加
	 *
	 * @param request
	 * @param createRankRequest
	 * @return
	 */
	@Override
	public Result add (HttpServletRequest request, CreateRankRequest createRankRequest)
	{
		return null;
	}

	/**
	 * 修改
	 *
	 * @param request
	 * @param modifyRankRequest
	 * @return
	 */
	@Override
	public Result update (HttpServletRequest request, ModifyRankRequest modifyRankRequest)
	{
		return null;
	}

	/**
	 * 删除
	 *
	 * @param request
	 * @param delRankRequest
	 * @return
	 */
	@Override
	public Result delete (HttpServletRequest request, DelRankRequest delRankRequest)
	{
		return null;
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
	{
		return null;
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
			QryRankConditionRequest qryRankConditionRequest)
	{
		return null;
	}
}
