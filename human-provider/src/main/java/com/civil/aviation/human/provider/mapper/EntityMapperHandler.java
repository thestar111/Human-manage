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

import com.civil.aviation.human.api.assess.domain.AssessContentVo;
import com.civil.aviation.human.api.assess.domain.AssessResultVo;
import com.civil.aviation.human.api.assess.domain.AssessTopicVo;
import com.civil.aviation.human.api.department.domain.DepartmentVo;
import com.civil.aviation.human.api.job.domain.JobVo;
import com.civil.aviation.human.api.menu.domain.MenuVo;
import com.civil.aviation.human.api.rank.domain.RankVo;
import com.civil.aviation.human.api.user.domain.EmployeeVo;
import com.civil.aviation.human.database.entity.*;
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

	/**
	 * @param rankVo
	 * @return
	 */
	@Mapping (target = "id", source = "rankId")
	Rank voToRank (RankVo rankVo);

	/**
	 * @param rank
	 * @return
	 */
	@Mapping (target = "rankId", source = "id")
	RankVo rankToVo (Rank rank);

	/**
	 * VO转实体
	 *
	 * @param assessTopicVo
	 * @return
	 */
	@Mapping (target = "id", source = "topicId")
	@Mapping (target = "rank", source = "rankId")
	@Mapping (target = "department", source = "departmentId")
	AssessTopic voTOAssessTopic (AssessTopicVo assessTopicVo);

	/**
	 * 实体转VO对象
	 *
	 * @param assessTopic
	 * @return
	 */
	@Mapping (target = "topicId", source = "id")
	@Mapping (target = "rankId", source = "rank")
	@Mapping (target = "departmentId", source = "department")
	AssessTopicVo assessTopicToVo (AssessTopic assessTopic);

	/**
	 * 实体转VO对象
	 *
	 * @param assessContent
	 * @return
	 */
	@Mapping (target = "assessContentId", source = "id")
	AssessContentVo assessContentToVo (AssessContent assessContent);

	/**
	 * VO转实体对象
	 *
	 * @param assessContent
	 * @return
	 */
	@Mapping (target = "id", source = "assessContentId")
	AssessContent voToAssessContent (AssessContentVo assessContent);

	/**
	 * VO转实体对象
	 *
	 * @param assessResultVo
	 * @return
	 */
	@Mapping (target = "id", source = "assessResultId")
	@Mapping (target = "employee", source = "employeeId")
	AssessResult voToAssessResult (AssessResultVo assessResultVo);

	/**
	 * 实体转VO对象
	 *
	 * @param assessResult
	 * @return
	 */
	@Mapping (target = "assessResultId", source = "id")
	@Mapping (target = "employeeId", source = "employee")
	AssessResultVo assessResultToVo (AssessResult assessResult);
}
