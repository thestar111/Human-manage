/**
 * 文 件 名:  UserApiImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/20 0020
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.provider.impl.user;

import com.civil.aviation.human.api.user.UserApi;
import com.civil.aviation.human.api.user.domain.EmployeeVo;
import com.civil.aviation.human.api.user.request.*;
import com.civil.aviation.human.api.user.response.QryEmployeeByIdResponse;
import com.civil.aviation.human.api.user.response.QryEmployeeConditionResponse;
import com.civil.aviation.human.common.core.annotation.Api;
import com.civil.aviation.human.common.core.domain.Result;
import com.civil.aviation.human.common.core.encryt.Coder;
import com.civil.aviation.human.common.core.utils.SessionUtils;
import com.civil.aviation.human.database.entity.AdminRoleRlat;
import com.civil.aviation.human.database.entity.Employee;
import com.civil.aviation.human.database.mapper.AdminRoleMapper;
import com.civil.aviation.human.database.mapper.EmployeeMappper;
import com.civil.aviation.human.provider.mapper.EntityMapperHandler;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * <>
 *
 * @author zping
 * @version 2018/3/20 0020
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Api
@Component
public class UserApiImpl implements UserApi
{
	/**
	 *
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (UserApiImpl.class);

	@Autowired
	private EmployeeMappper employeeMappper;

	@Autowired
	private AdminRoleMapper adminRoleMapper;

	/**
	 * 普通员工默认角色
	 */
	private String NORMAL_ROLE_DEFAULT = "1";

	@Value ("password.default")
	private String DEFAULT_PASSWORD;

	/**
	 * 用户注册接口
	 *
	 * @param request
	 * @return
	 */
	@Override
	public Result regist (HttpServletRequest request, CreateEmployeeRequest createEmployeeRequest) throws Exception
	{
		if (null == createEmployeeRequest || null == createEmployeeRequest.getEmployee ())
		{
			return Result.fail ("illega Parameters.");
		}

		//查询是否已存在该员工
		Employee employee1 = employeeMappper.queryEmployById (createEmployeeRequest.getEmployee ().getEmployeeId ());
		if (null != employee1)
		{
			return Result.fail ("员工已存在.");
		}

		Employee employee = EntityMapperHandler.INSTANCE.employeeToEntity (createEmployeeRequest.getEmployee ());
		if (StringUtils.isEmpty (employee.getPassword ()))
		{
			employee.setPassword (DEFAULT_PASSWORD);
		}
		employee.setPassword (Coder.encryptBASE64 (Coder.encryptMD5 (employee.getPassword ().getBytes ())));
		int flag = employeeMappper.add (employee);
		if (flag > 0)
		{
			//员工自注册绑定普通员工角色
			Map<String, String> params = Maps.newHashMap ();
			params.put ("admin", employee.getId ());
			params.put ("role", NORMAL_ROLE_DEFAULT);
			adminRoleMapper.bindRole (params);
			return Result.success ("user regist success.");
		}
		else
		{
			return Result.fail ("user regist failed.");
		}
	}

	/**
	 * 用户添加接口
	 *
	 * @param request
	 * @param createEmployeeRequest
	 * @return
	 */
	@Override
	public Result addUser (HttpServletRequest request, CreateEmployeeRequest createEmployeeRequest) throws Exception
	{
		if (null == createEmployeeRequest || null == createEmployeeRequest.getEmployee ())
		{
			return Result.fail ("illega Parameters.");
		}

		//查询是否已存在该员工
		Employee employee1 = employeeMappper.queryEmployById (createEmployeeRequest.getEmployee ().getEmployeeId ());
		if (null != employee1)
		{
			return Result.fail ("员工已存在.");
		}

		Employee employee = EntityMapperHandler.INSTANCE.employeeToEntity (createEmployeeRequest.getEmployee ());
		if (StringUtils.isEmpty (employee.getPassword ()))
		{
			employee.setPassword (DEFAULT_PASSWORD);
		}
		employee.setPassword (Coder.encryptBASE64 (Coder.encryptMD5 (employee.getPassword ().getBytes ())));
		//管理添加员工默认为正常用户
		employee.setSupplement (1);
		int flag = employeeMappper.add (employee);
		if (flag > 0)
		{
			//员工自注册绑定普通员工角色
			Map<String, String> params = Maps.newHashMap ();
			params.put ("admin", employee.getId ());
			params.put ("role", NORMAL_ROLE_DEFAULT);
			adminRoleMapper.bindRole (params);
			return Result.success ("user add success.");
		}
		else
		{
			return Result.fail ("user add failed.");
		}
	}

	/**
	 * 用户修改接口
	 *
	 * @param request
	 * @param modifyEmployeeRequest
	 * @return
	 */
	@Override
	public Result modify (HttpServletRequest request, ModifyEmployeeRequest modifyEmployeeRequest) throws Exception
	{
		if (null == modifyEmployeeRequest || null == modifyEmployeeRequest.getEmployee ())
		{
			return Result.fail ("illega Parameters.");
		}
		Employee employee = EntityMapperHandler.INSTANCE.employeeToEntity (modifyEmployeeRequest.getEmployee ());

		//绑定角色
		if (! StringUtils.isEmpty (employee.getRank ()))
		{
			Map<String, String> params = Maps.newHashMap ();
			params.put ("admin", employee.getId ());
			params.put ("role", employee.getRank ());
			adminRoleMapper.bindRole (params);
		}

		int flag = employeeMappper.modify (employee);

		if (flag > 0)
		{
			return Result.success ("user update success.");
		}
		else
		{
			return Result.fail ("user update failed.");
		}
	}

	/**
	 * 用户删除接口
	 *
	 * @param request
	 * @param delEmployeeRequest
	 * @return
	 */
	@Override
	public Result delete (HttpServletRequest request, DelEmployeeRequest delEmployeeRequest) throws Exception
	{
		if (StringUtils.isEmpty (delEmployeeRequest.getEmployeeId ()))
		{
			return Result.fail ("employeeId is null.");
		}

		int flag = employeeMappper.delete (delEmployeeRequest.getEmployeeId ());

		if (flag > 0)
		{
			return Result.success ("user delete success.");
		}
		else
		{
			return Result.fail ("user delete failed.");
		}
	}

	/**
	 * 用户查询接口
	 *
	 * @param request
	 * @param qryEmployeeByIdRequest
	 * @return
	 */
	@Override
	public QryEmployeeByIdResponse findById (HttpServletRequest request, QryEmployeeByIdRequest qryEmployeeByIdRequest)
			throws Exception
	{
		QryEmployeeByIdResponse qryEmployeeByIdResponse = null;
		if (StringUtils.isEmpty (qryEmployeeByIdRequest.getEmployeeId ()))
		{
			return (QryEmployeeByIdResponse) Result.fail ("employeeId is null.");
		}

		Employee employee = employeeMappper.queryEmployById (qryEmployeeByIdRequest.getEmployeeId ());
		EmployeeVo employeeVo = null;
		if (null != employee)
		{
			qryEmployeeByIdResponse = new QryEmployeeByIdResponse ();
			employeeVo = EntityMapperHandler.INSTANCE.employeeToDTO (employee);
			qryEmployeeByIdResponse.setEmployee (employeeVo);
			return qryEmployeeByIdResponse;
		}
		else
		{
			return (QryEmployeeByIdResponse) Result.success ("employee not exist.");
		}
	}

	/**
	 * 用户查询接口
	 *
	 * @param request
	 * @param qryEmployeeConditionRequest
	 * @return
	 */
	@Override
	public QryEmployeeConditionResponse queryByCondition (HttpServletRequest request,
			QryEmployeeConditionRequest qryEmployeeConditionRequest) throws Exception
	{
		QryEmployeeConditionResponse qryEmployeeConditionResponse = new QryEmployeeConditionResponse ();
		Map<String, Object> params = Maps.newHashMap ();

		if (null != qryEmployeeConditionRequest.getDepartment ())
		{
			params.put ("department", qryEmployeeConditionRequest.getDepartment ());
		}

		if (null != qryEmployeeConditionRequest.getJob ())
		{
			params.put ("job", qryEmployeeConditionRequest.getJob ());
		}

		if (! StringUtils.isEmpty (qryEmployeeConditionRequest.getName ()))
		{
			params.put ("name", qryEmployeeConditionRequest.getName ());
		}

		if (null != qryEmployeeConditionRequest.getRank ())
		{
			params.put ("rank", qryEmployeeConditionRequest.getRank ());
		}
		params.put ("pageIndex", qryEmployeeConditionRequest.getPageIndex ());
		params.put ("pageSize", qryEmployeeConditionRequest.getPageSize ());

		List<Employee> employees = employeeMappper.queryEmploy (params);
		List<EmployeeVo> employeeVos = null;

		if (! CollectionUtils.isEmpty (employees))
		{
			employeeVos = Lists.newArrayList ();
			EmployeeVo employeeVo = null;
			for (Employee employee : employees)
			{
				employeeVo = EntityMapperHandler.INSTANCE.employeeToDTO (employee);
				employeeVos.add (employeeVo);
			}
			qryEmployeeConditionResponse.setEmployees (employeeVos);
			qryEmployeeConditionResponse.setCount (employeeMappper.queryCountByCondition (params));
		}
		else
		{
			qryEmployeeConditionResponse.setEmployees (employeeVos);
			qryEmployeeConditionResponse.setCount (0);
		}
		return qryEmployeeConditionResponse;
	}

	/**
	 * 查询部门下的员工信息
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@Override
	public QryEmployeeConditionResponse queryByDepartment (HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		QryEmployeeConditionResponse qryEmployeeConditionResponse = new QryEmployeeConditionResponse ();
		Map<String, Object> params = Maps.newHashMap ();
		Employee employee = (Employee) SessionUtils.getValue (SessionUtils.EMPLOYEE_SESSION_KEY);
		if (null == employee)
		{
			return (QryEmployeeConditionResponse) Result.fail ("User not login.");
		}

		AdminRoleRlat adminRoleRlat = adminRoleMapper.findRoleById (employee.getId ());
		if (null == adminRoleRlat)
		{
			return (QryEmployeeConditionResponse) Result.fail ("该用户非法.");
		}

		if (! StringUtils.isEmpty (request.getParameter ("job")))
		{
			params.put ("job", request.getParameter ("job"));
		}

		if (! StringUtils.isEmpty (request.getParameter ("name")))
		{
			params.put ("name", request.getParameter ("name"));
		}

		if (! StringUtils.isEmpty (request.getParameter ("rank")))
		{
			params.put ("rank", request.getParameter ("rank"));
		}

		if (! StringUtils.isEmpty (request.getParameter ("office")))
		{
			params.put ("office", request.getParameter ("office"));
		}

		if (! StringUtils.isEmpty (request.getParameter ("department")))
		{
			params.put ("department", request.getParameter ("department"));
		}

		String pageIndex = request.getParameter ("pageIndex");
		String pageSize = request.getParameter ("pageSize");
		if (StringUtils.isEmpty (pageIndex))
		{
			pageIndex = "1";
		}
		if (StringUtils.isEmpty (pageSize))
		{
			pageSize = "10";
		}
		params.put ("pageIndex", (Integer.valueOf (pageIndex) - 1) * Integer.valueOf (pageSize));
		params.put ("pageSize", pageSize);

		List<Employee> employees = employeeMappper.queryEmploy (params);
		List<EmployeeVo> employeeVos = null;

		if (! CollectionUtils.isEmpty (employees))
		{
			employeeVos = Lists.newArrayList ();
			EmployeeVo employeeVo = null;
			for (Employee e : employees)
			{
				employeeVo = EntityMapperHandler.INSTANCE.employeeToDTO (e);
				employeeVos.add (employeeVo);
			}
			qryEmployeeConditionResponse.setEmployees (employeeVos);
			qryEmployeeConditionResponse.setCount (employeeMappper.queryCountByCondition (params));
		}
		else
		{
			qryEmployeeConditionResponse.setEmployees (employeeVos);
			qryEmployeeConditionResponse.setCount (0);
		}
		return qryEmployeeConditionResponse;
	}

	/**
	 * 查询新注册的员工信息
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@Override
	public QryEmployeeConditionResponse queryBySupplemnet (HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		QryEmployeeConditionResponse qryEmployeeConditionResponse = new QryEmployeeConditionResponse ();
		Map<String, Object> params = Maps.newHashMap ();
		Employee employee = (Employee) SessionUtils.getValue (SessionUtils.EMPLOYEE_SESSION_KEY);
		if (null == employee)
		{
			return (QryEmployeeConditionResponse) Result.fail ("User not login.");
		}

		if (! StringUtils.isEmpty (request.getParameter ("name")))
		{
			params.put ("name", request.getParameter ("name"));
		}

		String pageIndex = request.getParameter ("pageIndex");
		String pageSize = request.getParameter ("pageSize");
		if (StringUtils.isEmpty (pageIndex))
		{
			pageIndex = "1";
		}
		if (StringUtils.isEmpty (pageSize))
		{
			pageSize = "10";
		}
		params.put ("pageIndex", (Integer.valueOf (pageIndex) - 1) * Integer.valueOf (pageSize));
		params.put ("pageSize", pageSize);

		List<Employee> employees = employeeMappper.querySupplementEmploy (params);
		List<EmployeeVo> employeeVos = null;

		if (! CollectionUtils.isEmpty (employees))
		{
			employeeVos = Lists.newArrayList ();
			EmployeeVo employeeVo = null;
			for (Employee e : employees)
			{
				employeeVo = EntityMapperHandler.INSTANCE.employeeToDTO (e);
				employeeVos.add (employeeVo);
			}
			qryEmployeeConditionResponse.setEmployees (employeeVos);
			qryEmployeeConditionResponse.setCount (employeeMappper.querySupplementEmployCount (params));
		}
		else
		{
			qryEmployeeConditionResponse.setEmployees (employeeVos);
			qryEmployeeConditionResponse.setCount (0);
		}
		return qryEmployeeConditionResponse;
	}

	/**
	 * @param request
	 * @param resetPasswordRequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public Result resetPassword (HttpServletRequest request, ResetPasswordRequest resetPasswordRequest) throws Exception
	{
		if (StringUtils.isEmpty (resetPasswordRequest.getEmployeeId ()))
		{
			return Result.fail ("illega params.");
		}
		String encrytPassword = Coder.encryptBASE64 (Coder.encryptMD5 (DEFAULT_PASSWORD.getBytes ()));
		int flag = employeeMappper.resetPassword (resetPasswordRequest.getEmployeeId (), encrytPassword);
		if (flag > 0)
		{
			return Result.success ("user password reset success.");
		}
		else
		{
			return Result.fail ("user password reset failed.");
		}
	}

	/**
	 * @param request
	 * @param resetPasswordRequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public Result modifyPassword (HttpServletRequest request, ResetPasswordRequest resetPasswordRequest)
			throws Exception
	{
		String employeeId = (String) SessionUtils.getValue (SessionUtils.EMPLOYEE_ID_SESSION_KEY);

		if (StringUtils.isEmpty (employeeId))
		{
			return Result.fail ("user not login.");
		}

		if (StringUtils.isEmpty (resetPasswordRequest.getPassword ()))
		{
			return Result.fail ("illega params.");
		}

		if (StringUtils.isEmpty (resetPasswordRequest.getOldPassword ()))
		{
			return Result.fail ("illega params.");
		}

		//新密码
		String encrytPassword = Coder
				.encryptBASE64 (Coder.encryptMD5 (resetPasswordRequest.getPassword ().getBytes ()));

		//旧密码
		String oldPassword = Coder
				.encryptBASE64 (Coder.encryptMD5 (resetPasswordRequest.getOldPassword ().getBytes ()));

		int flag = employeeMappper.modifyPassword (employeeId, encrytPassword, oldPassword);

		if (flag > 0)
		{
			return Result.success ("user password modify success.");
		}
		else
		{
			return Result.fail ("user old password not right.");
		}
	}

	/**
	 * 根据部门，职级查询需要考核的员工
	 *
	 * @param request
	 * @param qryAssessEmployeeConditionRequest
	 * @return
	 */
	@Override
	public QryEmployeeConditionResponse queryAssessEmpByCondition (HttpServletRequest request,
			QryAssessEmployeeConditionRequest qryAssessEmployeeConditionRequest) throws Exception
	{
		QryEmployeeConditionResponse qryEmployeeConditionResponse = new QryEmployeeConditionResponse ();

		if (null == qryAssessEmployeeConditionRequest.getDepartment ())
		{
			return (QryEmployeeConditionResponse) Result.fail ("departmentId is null.");
		}

		if (null == qryAssessEmployeeConditionRequest.getRank ())
		{
			return (QryEmployeeConditionResponse) Result.fail ("rankId is null.");
		}

		if (StringUtils.isEmpty (qryAssessEmployeeConditionRequest.getTopicId ()))
		{
			return (QryEmployeeConditionResponse) Result.fail ("topicId is null.");
		}

		// 当前员工编号
		String disscussant = (String) SessionUtils.getValue (SessionUtils.EMPLOYEE_ID_SESSION_KEY);

		List<Employee> employees = employeeMappper
				.queryAssessEmploy (qryAssessEmployeeConditionRequest.getDepartment (),
						qryAssessEmployeeConditionRequest.getRank (), disscussant,
						qryAssessEmployeeConditionRequest.getTopicId ());
		List<EmployeeVo> employeeVos = null;
		if (! CollectionUtils.isEmpty (employees))
		{
			employeeVos = Lists.newArrayList ();
			EmployeeVo employeeVo = null;
			for (Employee employee : employees)
			{
				employeeVo = EntityMapperHandler.INSTANCE.employeeToDTO (employee);
				employeeVos.add (employeeVo);
			}
			qryEmployeeConditionResponse.setEmployees (employeeVos);
		}
		else
		{
			qryEmployeeConditionResponse.setEmployees (employeeVos);
		}
		return qryEmployeeConditionResponse;
	}
}
