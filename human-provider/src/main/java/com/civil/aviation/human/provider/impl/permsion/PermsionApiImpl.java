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
import com.civil.aviation.human.api.permsion.domain.PermsionVo;
import com.civil.aviation.human.api.permsion.request.CreatePermsionRequest;
import com.civil.aviation.human.api.permsion.request.DelPermsionRequest;
import com.civil.aviation.human.api.permsion.request.ModifyPermsionRequest;
import com.civil.aviation.human.api.permsion.request.QryPermsionByIdRequest;
import com.civil.aviation.human.api.permsion.response.QryPermsionByIdResponse;
import com.civil.aviation.human.common.core.annotation.Api;
import com.civil.aviation.human.common.core.domain.Result;
import com.civil.aviation.human.database.entity.Permsion;
import com.civil.aviation.human.database.mapper.PermsionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

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
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (PermsionApiImpl.class);

	@Autowired
	private PermsionMapper permsionMapper;

	/**
	 * 添加
	 *
	 * @param request
	 * @param createPermsionRequest
	 * @return
	 */
	@Override
	public Result add (HttpServletRequest request, CreatePermsionRequest createPermsionRequest) throws Exception
	{
		if (null == createPermsionRequest)
		{
			return Result.fail ("illega params.");
		}

		PermsionVo permsionVo = createPermsionRequest.getPermsion ();
		Permsion permsion = new Permsion ();
		BeanUtils.copyProperties (permsionVo, permsion);

		int flag = permsionMapper.add (permsion);

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
	 * @param modifyPermsionRequest
	 * @return
	 */
	@Override
	public Result update (HttpServletRequest request, ModifyPermsionRequest modifyPermsionRequest) throws Exception
	{
		if (null == modifyPermsionRequest)
		{
			return Result.fail ("illega params");
		}

		Permsion permsion = new Permsion ();
		BeanUtils.copyProperties (modifyPermsionRequest.getPermsion (), permsion);

		int flag = permsionMapper.modify (permsion);

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
	 * @param delPermsionRequest
	 * @return
	 */
	@Override
	public Result delete (HttpServletRequest request, DelPermsionRequest delPermsionRequest) throws Exception
	{
		if (null == delPermsionRequest.getPermsionId ())
		{
			Result.fail ("permsion id is null");
		}

		int flag = permsionMapper.delete (delPermsionRequest.getPermsionId ());

		if (flag > 0)
		{
			return new Result ();
		}
		else
		{
			return Result.fail ("delete permsion failed.");
		}
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
			throws Exception
	{
		QryPermsionByIdResponse qryPermsionByIdResponse = null;

		if (null == qryPermsionByIdRequest.getPermsionId ())
		{
			return (QryPermsionByIdResponse) Result.fail ("permsion id is null");
		}

		Permsion permsion = permsionMapper.find (qryPermsionByIdRequest.getPermsionId ());

		if (null != permsion)
		{
			PermsionVo permsionVo = new PermsionVo ();
			BeanUtils.copyProperties (permsion, permsionVo);
			qryPermsionByIdResponse = new QryPermsionByIdResponse ();
			qryPermsionByIdResponse.setPermsion (permsionVo);
			return qryPermsionByIdResponse;
		}
		else
		{
			return (QryPermsionByIdResponse) Result.fail ("permsion not exist");
		}
	}
}
