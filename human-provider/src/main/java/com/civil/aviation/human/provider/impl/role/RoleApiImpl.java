/**
 * 文 件 名:  RoleApiImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.provider.impl.role;

import com.civil.aviation.human.api.role.RoleApi;
import com.civil.aviation.human.api.role.request.CreateRoleRequest;
import com.civil.aviation.human.api.role.request.DelRoleRequest;
import com.civil.aviation.human.api.role.request.ModifyRoleRequest;
import com.civil.aviation.human.api.role.request.QryRoleByIdRequest;
import com.civil.aviation.human.api.role.response.QryRoleByIdResponse;
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
public class RoleApiImpl implements RoleApi
{
	/**
	 * 角色添加接口
	 *
	 * @param request
	 * @param createRoleRequest
	 * @return
	 */
	@Override
	public Result add (HttpServletRequest request, CreateRoleRequest createRoleRequest)
	{
		return null;
	}

	/**
	 * 修改接口
	 *
	 * @param request
	 * @param modifyRoleRequest
	 * @return
	 */
	@Override
	public Result modify (HttpServletRequest request, ModifyRoleRequest modifyRoleRequest)
	{
		return null;
	}

	/**
	 * 删除接口
	 *
	 * @param request
	 * @param delRoleRequest
	 * @return
	 */
	@Override
	public Result delete (HttpServletRequest request, DelRoleRequest delRoleRequest)
	{
		return null;
	}

	/**
	 * 角色查询接口
	 *
	 * @param request
	 * @param qryRoleByIdRequest
	 * @return
	 */
	@Override
	public QryRoleByIdResponse findById (HttpServletRequest request, QryRoleByIdRequest qryRoleByIdRequest)
	{
		return null;
	}
}
