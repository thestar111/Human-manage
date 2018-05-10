/**
 * 文 件 名:  AssessmentMapper
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/30 0030
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.database.mapper;

import com.civil.aviation.human.database.entity.AssessContent;
import com.civil.aviation.human.database.entity.AssessResult;
import com.civil.aviation.human.database.entity.AssessTopic;
import com.civil.aviation.human.database.entity.AssessTopicContent;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <考核核心API接口Mapper>
 *
 * @author zping
 * @version 2018/3/30 0030
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface AssessmentMapper
{

	/**
	 * 批量添加考核内容
	 *
	 * @param assessContents
	 * @return
	 * @throws SQLException
	 */
	int addAssessContent (List<AssessContent> assessContents) throws SQLException;

	/**
	 * 修改考核内容
	 *
	 * @param assessContent
	 * @return
	 * @throws SQLException
	 */
	int modifyAssessContent (AssessContent assessContent) throws SQLException;

	/**
	 * 修改考核内容
	 *
	 * @param assessContentId
	 * @return
	 * @throws SQLException
	 */
	AssessContent queryAssessContentById (String assessContentId) throws SQLException;

	/**
	 * 查询考核列表内容
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	List<AssessContent> queryAssessContents (Map<String, Object> params) throws SQLException;

	/**
	 * 查询考核列表内容总数
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	int queryAssessContentCount (Map<String, Object> params) throws SQLException;

	/**
	 * 添加考核主题
	 *
	 * @param assessTopic
	 * @return
	 * @throws SQLException
	 */
	int addAssessTopic (AssessTopic assessTopic) throws SQLException;

	/**
	 * 修改考核主题
	 *
	 * @param assessTopic
	 * @return
	 * @throws SQLException
	 */
	int modifyAssessTopic (AssessTopic assessTopic) throws SQLException;

	/**
	 * 添加考核成绩
	 *
	 * @param assessResult
	 * @return
	 * @throws SQLException
	 */
	int addAssessResult (AssessResult assessResult) throws SQLException;

	/**
	 * 根据员工编号，评论人编号查询
	 *
	 * @param employeeId
	 * @param discussant
	 * @return
	 * @throws SQLException
	 */
	AssessResult queryAssessResult (String employeeId, String discussant) throws SQLException;

	/**
	 * 根据员工编号查询上一年的考核成绩
	 *
	 * @param employeeId
	 * @param weight
	 * @return
	 * @throws SQLException
	 */
	List<AssessResult> queryAssessResultByEmployee (String employeeId, int weight) throws SQLException;

	/**
	 * 根据员工编号查询上一年的考核成绩
	 *
	 * @param employeeId
	 * @return
	 * @throws SQLException
	 */
	AssessResult queryAssessResultBySelf (String employeeId) throws SQLException;

	/**
	 * 删除考核主题
	 *
	 * @param topicId
	 * @return
	 * @throws SQLException
	 */
	int deleteAssessTopic (String topicId) throws SQLException;

	/**
	 * 删除考核内容
	 *
	 * @param assessContentId
	 * @return
	 * @throws SQLException
	 */
	int deleteAssessContent (String assessContentId) throws SQLException;

	/**
	 * 查询当前生效的已发布的考核主题
	 *
	 * @return
	 * @throws SQLException
	 */
	List<AssessTopicContent> qryEffectiveAssessTopic () throws SQLException;

	/**
	 * 根据考核主题编号查询考核标准
	 *
	 * @param catalogId
	 * @return
	 * @throws SQLException
	 */
	List<AssessContent> qryAssessContentByCatalogId (String catalogId) throws SQLException;

	/**
	 * 根据查询条件查询考核主题
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	List<AssessTopic> qryAssessTopicByCondition (Map<String, Object> params) throws SQLException;

	/**
	 * 查询总数
	 *
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	int qryAssessTopicCountByCondition (Map<String, Object> params) throws SQLException;

}
