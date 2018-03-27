/**
 * 文 件 名:  PermsionApiImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.provider.impl.permsion;

import com.civil.aviation.human.api.permsion.PermsionApi;
import com.civil.aviation.human.api.permsion.request.*;
import com.civil.aviation.human.api.permsion.response.QryPermsionByIdResponse;
import com.civil.aviation.human.api.permsion.response.QryPermsionConditionResponse;
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
public class PermsionApiImpl implements PermsionApi
{
	/**
	 * 添加
	 *
	 * @param request
	 * @param createPermsionRequest
	 * @return
	 */
	@Override
	public Result add (HttpServletRequest request, CreatePermsionRequest createPermsionRequest)
	{
		return null;
	}

	/**
	 * 修改
	 *
	 * @param request
	 * @param modifyPermsionRequest
	 * @return
	 */
	@Override
	public Result update (HttpServletRequest request, ModifyPermsionRequest modifyPermsionRequest)
	{
		return null;
	}

	/**
	 * 删除
	 *
	 * @param request
	 * @param delPermsionRequest
	 * @return
	 */
	@Override
	public Result delete (HttpServletRequest request, DelPermsionRequest delPermsionRequest)
	{
		return null;
	}

	/**
	 * 查询
	 *
	 * @param request
	 * @param qryPermsionByIdRequest
	 * @return
	 */
	@Override
	public QryPermsionByIdResponse findById (HttpServletRequest request, QryPermsionByIdRequest qryPermsionByIdRequest)
	{
		return null;
	}

	/**
	 * 查询列表
	 *
	 * @param request
	 * @param qryPermsionConditionRequest
	 * @return
	 */
	@Override
	public QryPermsionConditionResponse queryConditionPage (HttpServletRequest request,
			QryPermsionConditionRequest qryPermsionConditionRequest)
	{
		return null;
	}
}
