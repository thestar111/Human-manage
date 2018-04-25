/**
 * 文 件 名:  App
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/20 0020
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.human.bootstrap.test;

import com.civil.aviation.human.api.user.domain.EmployeeVo;
import com.civil.aviation.human.boot.HumanBootstrap;
import com.civil.aviation.human.database.entity.AssessResult;
import com.civil.aviation.human.database.entity.Employee;
import com.civil.aviation.human.database.entity.Permsion;
import com.civil.aviation.human.database.entity.Role;
import com.civil.aviation.human.database.mapper.*;
import com.civil.aviation.human.provider.mapper.EntityMapperHandler;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/20 0020
 * @see [相关类/方法]
 * @since [产品/模块版本]x`
 */
@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest (classes = HumanBootstrap.class)
public class App
{

	@Autowired
	private EmployeeMappper employeeMappper;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private PermsionMapper permsionMapper;

	@Autowired
	private LoginMapper loginMapper;

	@Autowired
	private AssessmentMapper assessmentMapper;

	@Test
	public void bootstrap ()
	{
		Employee employee = new Employee ();
		employee.setId ("20113393");
		employee.setEmail ("zhouping19911013@163.com");
		EmployeeVo employDto = EntityMapperHandler.INSTANCE.employeeToDTO (employee);
		System.out.println (employDto);
	}

	@Test
	public void db () throws SQLException
	{
		EmployeeVo employDto = new EmployeeVo ();
		employDto.setEmail ("zhouping19911013@163.com");
		employDto.setBirthday ("1991-10-13");
		employDto.setEmployeeId ("20113394");
		employDto.setHomeAddr ("guangzhou");
		Employee employee = EntityMapperHandler.INSTANCE.employeeToEntity (employDto);
		employeeMappper.add (employee);
	}

	/**
	 * 查询角色信息
	 *
	 * @throws Exception
	 */
	@Test
	public void getRole () throws Exception
	{
		Set<Role> roles = roleMapper.qryRoleByEmployeeId ("20113392");
		System.out.println (roles.size ());
		System.out.println (roles);
	}

	/**
	 * 查询用户所有权限信息
	 *
	 * @throws Exception
	 */
	@Test
	public void getPermsion () throws Exception
	{
		List<Integer> roleIds = Lists.newArrayList ();
		roleIds.add (1);
		roleIds.add (2);
		Set<String> permsions = permsionMapper.qryUserAllPersion (roleIds);
		System.out.println (permsions.size ());
		System.out.println (permsions);
	}

	@Test
	public void login () throws Exception
	{
		Employee employee = loginMapper.login ("20113392", "123456");
		System.out.println (employee);
	}

	@Test
	public void list () throws Exception
	{
		Map<String, Object> params = Maps.newHashMap ();
		params.put ("department", 1);
		List<Employee> employee = employeeMappper.queryEmploy (params);
		System.out.println (employee);
	}

	@Test
	public void addResult () throws Exception
	{
		AssessResult result = assessmentMapper.queryAssessResult ("107189", "20113392");
		System.out.println (result);
		/*AssessResult assessResult = new AssessResult ();
		assessResult.setDiscussant ("20113392");
		assessResult.setEmployee ("107189");
		assessResult.setScore (90.00);
		assessResult.setTopic ("20180413");
		assessmentMapper.addAssessResult (assessResult);*/
	}
}
