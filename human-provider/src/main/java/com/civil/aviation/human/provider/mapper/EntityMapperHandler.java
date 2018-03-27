/**
 * 文 件 名:  EntityMapperHandler
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/20 0020
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.provider.mapper;

import com.civil.aviation.human.api.department.domain.DepartmentVo;
import com.civil.aviation.human.api.job.domain.JobVo;
import com.civil.aviation.human.api.menu.domain.MenuVo;
import com.civil.aviation.human.api.user.domain.EmployeeVo;
import com.civil.aviation.human.database.entity.Department;
import com.civil.aviation.human.database.entity.Employee;
import com.civil.aviation.human.database.entity.Job;
import com.civil.aviation.human.database.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * <实体映射转换实现>
 *
 * @author zping
 * @version 2018/3/20 0020
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Mapper
public interface EntityMapperHandler
{

	/**
	 * 映射实体实例
	 */
	EntityMapperHandler INSTANCE = Mappers.getMapper (EntityMapperHandler.class);

	/**
	 * PO转DTO
	 *
	 * @param employee PO
	 * @return DTO
	 */
	@Mapping (target = "employeeId", source = "id")
	EmployeeVo employeeToDTO (Employee employee);

	/**
	 * PO转DTO
	 *
	 * @param employDto PO
	 * @return DTO
	 */
	@Mapping (target = "id", source = "employeeId")
	Employee employeeToEntity (EmployeeVo employDto);

	/**
	 * Department转成Vo对象
	 *
	 * @param department
	 * @return
	 */
	@Mapping (target = "departmentId", source = "id")
	DepartmentVo departmentToVo (Department department);

	/**
	 * Department转成Vo对象
	 *
	 * @param department
	 * @return
	 */
	@Mapping (target = "id", source = "departmentId")
	Department departmentVoToEntity (DepartmentVo department);

	/**
	 * Job转Vo对象
	 *
	 * @param job
	 * @return
	 */
	@Mapping (target = "jobId", source = "id")
	JobVo jobTOVo (Job job);

	/**
	 * Vo转成实体对象
	 *
	 * @param job
	 * @param jobVo
	 */
	@Mapping (target = "id", source = "jobId")
	void voToJob (@MappingTarget Job job, JobVo jobVo);

	/**
	 * Menu转Vo对象
	 *
	 * @param menu
	 * @return
	 */
	MenuVo menuTOVo (Menu menu);

	/**
	 * Vo转成实体对象
	 *
	 * @param menu
	 * @param menuVo
	 */
	void voToMenu (@MappingTarget Menu menu, MenuVo menuVo);
}
