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
import com.civil.aviation.human.api.role.domain.RoleVo;
import com.civil.aviation.human.api.role.request.CreateRoleRequest;
import com.civil.aviation.human.api.role.request.DelRoleRequest;
import com.civil.aviation.human.api.role.request.ModifyRoleRequest;
import com.civil.aviation.human.api.role.request.QryRoleByIdRequest;
import com.civil.aviation.human.api.role.response.QryRoleByIdResponse;
import com.civil.aviation.human.common.core.annotation.Api;
import com.civil.aviation.human.common.core.domain.Result;
import com.civil.aviation.human.database.entity.Role;
import com.civil.aviation.human.database.mapper.RoleMapper;
import com.civil.aviation.human.provider.mapper.EntityMapperHandler;
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
public class RoleApiImpl implements RoleApi
{

	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (RoleApiImpl.class);

	@Autowired
	private RoleMapper roleMapper;

	/**
	 * 角色添加接口
	 *
	 * @param request
	 * @param createRoleRequest
	 * @return
	 */
	@Override
	public Result add (HttpServletRequest request, CreateRoleRequest createRoleRequest) throws Exception
	{
		if (null == createRoleRequest)
		{
			return Result.fail ("illega params.");
		}

		RoleVo roleVo = createRoleRequest.getRole ();
		Role role = new Role ();
		BeanUtils.copyProperties (roleVo, role);

		int flag = roleMapper.add (role);

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
	 * 修改接口
	 *
	 * @param request
	 * @param modifyRoleRequest
	 * @return
	 */
	@Override
	public Result modify (HttpServletRequest request, ModifyRoleRequest modifyRoleRequest) throws Exception
	{
		if (null == modifyRoleRequest)
		{
			return Result.fail ("illega params.");
		}

		RoleVo roleVo = modifyRoleRequest.getRole ();
		Role role = new Role ();
		BeanUtils.copyProperties (roleVo, role);

		int flag = roleMapper.modify (role);

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
	 * 删除接口
	 *
	 * @param request
	 * @param delRoleRequest
	 * @return
	 */
	@Override
	public Result delete (HttpServletRequest request, DelRoleRequest delRoleRequest) throws Exception
	{
		if (null == delRoleRequest || null == delRoleRequest.getRoleId ())
		{
			return Result.fail ("illega params.");
		}

		int flag = roleMapper.delete (delRoleRequest.getRoleId ());
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
	 * 角色查询接口
	 *
	 * @param request
	 * @param qryRoleByIdRequest
	 * @return
	 */
	@Override
	public QryRoleByIdResponse findById (HttpServletRequest request, QryRoleByIdRequest qryRoleByIdRequest)
			throws Exception
	{
		QryRoleByIdResponse qryRoleByIdResponse = null;

		if (null == qryRoleByIdRequest.getRoleId ())
		{
			return (QryRoleByIdResponse) Result.fail ("roleId is null");
		}

		Role role = roleMapper.find (qryRoleByIdRequest.getRoleId ());

		if (null != role)
		{
			qryRoleByIdResponse = new QryRoleByIdResponse ();
			RoleVo roleVo = new RoleVo ();
			BeanUtils.copyProperties (role, roleVo);
			qryRoleByIdResponse.setRole (roleVo);
			return qryRoleByIdResponse;
		}
		else
		{
			return (QryRoleByIdResponse) Result.success ("role not exist.");
		}
	}
}
