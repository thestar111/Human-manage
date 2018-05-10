package com.civil.aviation.human.provider.mapper;

import com.civil.aviation.human.api.assess.domain.AssessContentVo;
import com.civil.aviation.human.api.assess.domain.AssessResultVo;
import com.civil.aviation.human.api.assess.domain.AssessTopicVo;
import com.civil.aviation.human.api.department.domain.DepartmentVo;
import com.civil.aviation.human.api.job.domain.JobVo;
import com.civil.aviation.human.api.menu.domain.MenuVo;
import com.civil.aviation.human.api.office.domain.OfficeVo;
import com.civil.aviation.human.api.rank.domain.RankVo;
import com.civil.aviation.human.api.user.domain.EmployeeVo;
import com.civil.aviation.human.database.entity.AssessContent;
import com.civil.aviation.human.database.entity.AssessResult;
import com.civil.aviation.human.database.entity.AssessTopic;
import com.civil.aviation.human.database.entity.Department;
import com.civil.aviation.human.database.entity.Employee;
import com.civil.aviation.human.database.entity.Job;
import com.civil.aviation.human.database.entity.Menu;
import com.civil.aviation.human.database.entity.Office;
import com.civil.aviation.human.database.entity.Rank;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-05-10T16:08:30+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
public class EntityMapperHandlerImpl implements EntityMapperHandler {

    @Override
    public EmployeeVo employeeToDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeVo employeeVo = new EmployeeVo();

        employeeVo.setEmployeeId( employee.getId() );
        employeeVo.setName( employee.getName() );
        employeeVo.setPassword( employee.getPassword() );
        employeeVo.setEnglishName( employee.getEnglishName() );
        employeeVo.setSex( employee.getSex() );
        employeeVo.setHomeAddr( employee.getHomeAddr() );
        employeeVo.setBirthday( employee.getBirthday() );
        employeeVo.setTel( employee.getTel() );
        employeeVo.setNation( employee.getNation() );
        employeeVo.setEmail( employee.getEmail() );
        employeeVo.setLastUpdateTime( employee.getLastUpdateTime() );
        employeeVo.setCreateTime( employee.getCreateTime() );
        employeeVo.setDepartment( employee.getDepartment() );
        employeeVo.setSalary( employee.getSalary() );
        employeeVo.setJob( employee.getJob() );
        employeeVo.setRank( employee.getRank() );
        employeeVo.setOffice( employee.getOffice() );
        employeeVo.setDepartName( employee.getDepartName() );
        employeeVo.setRankName( employee.getRankName() );
        employeeVo.setJobName( employee.getJobName() );
        employeeVo.setSupplement( employee.getSupplement() );
        employeeVo.setOfficeName( employee.getOfficeName() );

        return employeeVo;
    }

    @Override
    public Employee employeeToEntity(EmployeeVo employDto) {
        if ( employDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employDto.getEmployeeId() );
        employee.setName( employDto.getName() );
        employee.setPassword( employDto.getPassword() );
        employee.setEnglishName( employDto.getEnglishName() );
        employee.setSex( employDto.getSex() );
        employee.setHomeAddr( employDto.getHomeAddr() );
        employee.setBirthday( employDto.getBirthday() );
        employee.setTel( employDto.getTel() );
        employee.setNation( employDto.getNation() );
        employee.setEmail( employDto.getEmail() );
        employee.setLastUpdateTime( employDto.getLastUpdateTime() );
        employee.setCreateTime( employDto.getCreateTime() );
        employee.setDepartment( employDto.getDepartment() );
        employee.setSalary( employDto.getSalary() );
        employee.setJob( employDto.getJob() );
        employee.setRank( employDto.getRank() );
        employee.setOffice( employDto.getOffice() );
        employee.setDepartName( employDto.getDepartName() );
        employee.setRankName( employDto.getRankName() );
        employee.setJobName( employDto.getJobName() );
        employee.setOfficeName( employDto.getOfficeName() );
        employee.setSupplement( employDto.getSupplement() );

        return employee;
    }

    @Override
    public DepartmentVo departmentToVo(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentVo departmentVo = new DepartmentVo();

        departmentVo.setDepartmentId( department.getId() );
        departmentVo.setName( department.getName() );
        departmentVo.setCreateTime( department.getCreateTime() );
        departmentVo.setMemo( department.getMemo() );
        departmentVo.setTel( department.getTel() );
        departmentVo.setManager( department.getManager() );

        return departmentVo;
    }

    @Override
    public Department departmentVoToEntity(DepartmentVo department) {
        if ( department == null ) {
            return null;
        }

        Department department1 = new Department();

        if ( department.getDepartmentId() != null ) {
            department1.setId( department.getDepartmentId() );
        }
        department1.setName( department.getName() );
        department1.setCreateTime( department.getCreateTime() );
        department1.setMemo( department.getMemo() );
        department1.setTel( department.getTel() );
        department1.setManager( department.getManager() );

        return department1;
    }

    @Override
    public JobVo jobTOVo(Job job) {
        if ( job == null ) {
            return null;
        }

        JobVo jobVo = new JobVo();

        jobVo.setJobId( job.getId() );
        jobVo.setName( job.getName() );
        jobVo.setMemo( job.getMemo() );
        jobVo.setCreateTime( job.getCreateTime() );

        return jobVo;
    }

    @Override
    public void voToJob(Job job, JobVo jobVo) {
        if ( jobVo == null ) {
            return;
        }

        if ( jobVo.getJobId() != null ) {
            job.setId( jobVo.getJobId() );
        }
        job.setName( jobVo.getName() );
        job.setMemo( jobVo.getMemo() );
        job.setCreateTime( jobVo.getCreateTime() );
    }

    @Override
    public MenuVo menuTOVo(Menu menu) {
        if ( menu == null ) {
            return null;
        }

        MenuVo menuVo = new MenuVo();

        menuVo.setMenuId( menu.getMenuId() );
        menuVo.setMenuName( menu.getMenuName() );
        menuVo.setParentMenuId( menu.getParentMenuId() );
        menuVo.setMenuType( menu.getMenuType() );
        menuVo.setLeaf( menu.getLeaf() );
        menuVo.setSort( menu.getSort() );
        menuVo.setMenuUrl( menu.getMenuUrl() );
        menuVo.setMemo( menu.getMemo() );

        return menuVo;
    }

    @Override
    public void voToMenu(Menu menu, MenuVo menuVo) {
        if ( menuVo == null ) {
            return;
        }

        menu.setMenuId( menuVo.getMenuId() );
        menu.setMenuName( menuVo.getMenuName() );
        menu.setParentMenuId( menuVo.getParentMenuId() );
        menu.setMenuType( menuVo.getMenuType() );
        menu.setLeaf( menuVo.getLeaf() );
        menu.setSort( menuVo.getSort() );
        menu.setMenuUrl( menuVo.getMenuUrl() );
        menu.setMemo( menuVo.getMemo() );
    }

    @Override
    public Rank voToRank(RankVo rankVo) {
        if ( rankVo == null ) {
            return null;
        }

        Rank rank = new Rank();

        rank.setId( rankVo.getRankId() );
        rank.setName( rankVo.getName() );
        rank.setMemo( rankVo.getMemo() );
        rank.setCreateTime( rankVo.getCreateTime() );

        return rank;
    }

    @Override
    public RankVo rankToVo(Rank rank) {
        if ( rank == null ) {
            return null;
        }

        RankVo rankVo = new RankVo();

        rankVo.setRankId( rank.getId() );
        rankVo.setName( rank.getName() );
        rankVo.setMemo( rank.getMemo() );
        rankVo.setCreateTime( rank.getCreateTime() );

        return rankVo;
    }

    @Override
    public AssessTopic voTOAssessTopic(AssessTopicVo assessTopicVo) {
        if ( assessTopicVo == null ) {
            return null;
        }

        AssessTopic assessTopic = new AssessTopic();

        assessTopic.setRank( assessTopicVo.getRankId() );
        assessTopic.setId( assessTopicVo.getTopicId() );
        assessTopic.setDepartment( assessTopicVo.getDepartmentId() );
        assessTopic.setTitle( assessTopicVo.getTitle() );
        assessTopic.setStartTime( assessTopicVo.getStartTime() );
        assessTopic.setEndTime( assessTopicVo.getEndTime() );
        assessTopic.setStatus( assessTopicVo.getStatus() );
        assessTopic.setExtend1( assessTopicVo.getExtend1() );
        assessTopic.setExtend2( assessTopicVo.getExtend2() );
        assessTopic.setExtend3( assessTopicVo.getExtend3() );
        assessTopic.setExtend4( assessTopicVo.getExtend4() );
        assessTopic.setExtend5( assessTopicVo.getExtend5() );
        assessTopic.setExtend6( assessTopicVo.getExtend6() );
        assessTopic.setAssessContent( assessTopicVo.getAssessContent() );
        assessTopic.setCatalogName( assessTopicVo.getCatalogName() );

        return assessTopic;
    }

    @Override
    public AssessTopicVo assessTopicToVo(AssessTopic assessTopic) {
        if ( assessTopic == null ) {
            return null;
        }

        AssessTopicVo assessTopicVo = new AssessTopicVo();

        assessTopicVo.setTopicId( assessTopic.getId() );
        assessTopicVo.setRankId( assessTopic.getRank() );
        assessTopicVo.setDepartmentId( assessTopic.getDepartment() );
        assessTopicVo.setTitle( assessTopic.getTitle() );
        assessTopicVo.setStartTime( assessTopic.getStartTime() );
        assessTopicVo.setEndTime( assessTopic.getEndTime() );
        assessTopicVo.setStatus( assessTopic.getStatus() );
        assessTopicVo.setExtend1( assessTopic.getExtend1() );
        assessTopicVo.setExtend2( assessTopic.getExtend2() );
        assessTopicVo.setExtend3( assessTopic.getExtend3() );
        assessTopicVo.setExtend4( assessTopic.getExtend4() );
        assessTopicVo.setExtend5( assessTopic.getExtend5() );
        assessTopicVo.setExtend6( assessTopic.getExtend6() );
        assessTopicVo.setAssessContent( assessTopic.getAssessContent() );
        assessTopicVo.setCatalogName( assessTopic.getCatalogName() );

        return assessTopicVo;
    }

    @Override
    public AssessContentVo assessContentToVo(AssessContent assessContent) {
        if ( assessContent == null ) {
            return null;
        }

        AssessContentVo assessContentVo = new AssessContentVo();

        assessContentVo.setAssessContentId( assessContent.getId() );
        assessContentVo.setContent( assessContent.getContent() );
        assessContentVo.setGrade( assessContent.getGrade() );
        assessContentVo.setCatalog( assessContent.getCatalog() );
        assessContentVo.setTime( assessContent.getTime() );

        return assessContentVo;
    }

    @Override
    public AssessContent voToAssessContent(AssessContentVo assessContent) {
        if ( assessContent == null ) {
            return null;
        }

        AssessContent assessContent1 = new AssessContent();

        if ( assessContent.getAssessContentId() != null ) {
            assessContent1.setId( assessContent.getAssessContentId() );
        }
        assessContent1.setContent( assessContent.getContent() );
        assessContent1.setGrade( assessContent.getGrade() );
        assessContent1.setCatalog( assessContent.getCatalog() );
        assessContent1.setTime( assessContent.getTime() );

        return assessContent1;
    }

    @Override
    public AssessResult voToAssessResult(AssessResultVo assessResultVo) {
        if ( assessResultVo == null ) {
            return null;
        }

        AssessResult assessResult = new AssessResult();

        assessResult.setEmployee( assessResultVo.getEmployeeId() );
        if ( assessResultVo.getAssessResultId() != null ) {
            assessResult.setId( assessResultVo.getAssessResultId() );
        }
        assessResult.setTopic( assessResultVo.getTopic() );
        assessResult.setWeight( assessResultVo.getWeight() );
        assessResult.setScore( assessResultVo.getScore() );
        assessResult.setDiscussant( assessResultVo.getDiscussant() );
        assessResult.setTime( assessResultVo.getTime() );

        return assessResult;
    }

    @Override
    public AssessResultVo assessResultToVo(AssessResult assessResult) {
        if ( assessResult == null ) {
            return null;
        }

        AssessResultVo assessResultVo = new AssessResultVo();

        assessResultVo.setEmployeeId( assessResult.getEmployee() );
        assessResultVo.setAssessResultId( assessResult.getId() );
        assessResultVo.setTopic( assessResult.getTopic() );
        assessResultVo.setWeight( assessResult.getWeight() );
        assessResultVo.setScore( assessResult.getScore() );
        assessResultVo.setDiscussant( assessResult.getDiscussant() );
        assessResultVo.setTime( assessResult.getTime() );

        return assessResultVo;
    }

    @Override
    public Office officeToEntity(OfficeVo officeVo) {
        if ( officeVo == null ) {
            return null;
        }

        Office office = new Office();

        office.setDepartment( officeVo.getDepartmentId() );
        if ( officeVo.getOfficeId() != null ) {
            office.setId( officeVo.getOfficeId() );
        }
        office.setName( officeVo.getName() );
        office.setCreateTime( officeVo.getCreateTime() );
        office.setManager( officeVo.getManager() );
        office.setMemo( officeVo.getMemo() );
        office.setTel( officeVo.getTel() );

        return office;
    }

    @Override
    public OfficeVo officeToVo(Office office) {
        if ( office == null ) {
            return null;
        }

        OfficeVo officeVo = new OfficeVo();

        officeVo.setOfficeId( office.getId() );
        officeVo.setDepartmentId( office.getDepartment() );
        officeVo.setName( office.getName() );
        officeVo.setCreateTime( office.getCreateTime() );
        officeVo.setMemo( office.getMemo() );
        officeVo.setManager( office.getManager() );
        officeVo.setTel( office.getTel() );

        return officeVo;
    }
}
