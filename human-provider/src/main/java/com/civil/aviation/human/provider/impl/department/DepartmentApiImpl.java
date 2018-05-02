/**
 * 文 件 名:  DepartmentApiImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.provider.impl.department;

import com.civil.aviation.human.api.department.DepartmentApi;
import com.civil.aviation.human.api.department.domain.DepartmentVo;
import com.civil.aviation.human.api.department.request.CreateDepartmentRequest;
import com.civil.aviation.human.api.department.request.DelPartmentRequest;
import com.civil.aviation.human.api.department.request.ModifyDepartmentRequest;
import com.civil.aviation.human.api.department.request.QryDepartmentByIdRequest;
import com.civil.aviation.human.api.department.response.QryDepartmentByIdResponse;
import com.civil.aviation.human.api.department.response.QryDepartmentResponse;
import com.civil.aviation.human.common.core.annotation.Api;
import com.civil.aviation.human.common.core.domain.Result;
import com.civil.aviation.human.database.entity.Department;
import com.civil.aviation.human.database.mapper.DepartmentMapper;
import com.civil.aviation.human.provider.mapper.EntityMapperHandler;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class DepartmentApiImpl implements DepartmentApi
{

	@Autowired
	private DepartmentMapper departmentMapper;

	/**
	 * 添加
	 *
	 * @param request
	 * @param createDepartmentRequest
	 * @return
	 */
	@Validated
	@Override
	public Result add (HttpServletRequest request, CreateDepartmentRequest createDepartmentRequest) throws Exception
	{

		if (null == createDepartmentRequest)
		{
			return Result.fail ("illage params");
		}

		Department department = EntityMapperHandler.INSTANCE
				.departmentVoToEntity (createDepartmentRequest.getDepartment ());

		int flag = departmentMapper.add (department);

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
	 * @param modifyDepartmentRequest`
	 * @return
	 */
	@Override
	public Result update (HttpServletRequest request, ModifyDepartmentRequest modifyDepartmentRequest) throws Exception
	{
		if (null == modifyDepartmentRequest)
		{
			return Result.fail ("illage params");
		}

		Department department = EntityMapperHandler.INSTANCE
				.departmentVoToEntity (modifyDepartmentRequest.getDepartment ());

		int flag = departmentMapper.modify (department);

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
	 * @param delPartmentRequest
	 * @return
	 */
	@Override
	public Result delete (HttpServletRequest request, DelPartmentRequest delPartmentRequest) throws Exception
	{
		if (null == delPartmentRequest.getDepartmentId ())
		{
			Result.fail ("department id is null");
		}

		int flag = departmentMapper.delete (delPartmentRequest.getDepartmentId ());

		if (flag > 0)
		{
			return new Result ();
		}
		else
		{
			return Result.fail ("delete department failed.");
		}
	}

	/**
	 * 查询
	 *
	 * @param request
	 * @param qryDepartmentByIdRequest
	 * @return
	 */
	@Override
	public QryDepartmentByIdResponse findById (HttpServletRequest request,
			QryDepartmentByIdRequest qryDepartmentByIdRequest) throws Exception
	{
		QryDepartmentByIdResponse qryDepartmentByIdResponse = null;

		if (null == qryDepartmentByIdRequest.getDepartmentId ())
		{
			return (QryDepartmentByIdResponse) Result.fail ("department id is null");
		}

		Department department = departmentMapper.findById (qryDepartmentByIdRequest.getDepartmentId ());

		if (null != department)
		{
			DepartmentVo departmentVo = EntityMapperHandler.INSTANCE.departmentToVo (department);
			qryDepartmentByIdResponse = new QryDepartmentByIdResponse ();
			qryDepartmentByIdResponse.setDepartment (departmentVo);
			return qryDepartmentByIdResponse;
		}
		else
		{
			return (QryDepartmentByIdResponse) Result.fail ("department not exist");
		}
	}

	/**
	 * 查询列表
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@Override
	public QryDepartmentResponse queryConditionPage (HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		QryDepartmentResponse qryDepartmentResponse = new QryDepartmentResponse ();
		Map<String, Object> params = Maps.newHashMap ();

		if (! StringUtils.isEmpty (request.getParameter ("departmentName")))
		{
			params.put ("name", request.getParameter ("departmentName"));
		}

		if (! StringUtils.isEmpty (request.getParameter ("manager")))
		{
			params.put ("id", request.getParameter ("manager"));
		}
		String pageIndex = request.getParameter ("pageIndex");
		if (StringUtils.isEmpty (pageIndex))
		{
			pageIndex = "1";
		}
		params.put ("pageIndex", Integer.valueOf (pageIndex) - 1);
		params.put ("pageSize", request.getParameter ("pageSize"));

		List<Department> departments = departmentMapper.findByCondition (params);
		List<DepartmentVo> departmentVos = null;
		if (! CollectionUtils.isEmpty (departments))
		{
			departmentVos = Lists.newArrayList ();
			DepartmentVo departmentVo = null;
			for (Department department : departments)
			{
				departmentVo = EntityMapperHandler.INSTANCE.departmentToVo (department);
				departmentVos.add (departmentVo);
			}
			qryDepartmentResponse.setDepartments (departmentVos);
			qryDepartmentResponse.setCount (departmentMapper.findCountByCondition (params));
			return qryDepartmentResponse;
		}
		else
		{
			qryDepartmentResponse.setDepartments (departmentVos);
			qryDepartmentResponse.setCount (0);
			return qryDepartmentResponse;
		}
	}
}
