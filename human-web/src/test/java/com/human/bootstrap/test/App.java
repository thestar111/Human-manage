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
import com.civil.aviation.human.database.entity.Employee;
import com.civil.aviation.human.database.mapper.EmployeeMappper;
import com.civil.aviation.human.provider.mapper.EntityMapperHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

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
}
