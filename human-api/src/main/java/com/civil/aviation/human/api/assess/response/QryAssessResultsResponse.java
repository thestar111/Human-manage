/**
 * 文 件 名:  QryAssessResultByEmployResponse
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.assess.response;

import com.civil.aviation.human.api.assess.domain.AssessGradeVo;
import com.civil.aviation.human.common.core.domain.Result;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <查询考核成绩信息>
 *
 * @author zping
 * @version 2018/4/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QryAssessResultsResponse extends Result
{
	/**
	 * 考核成绩列表
	 */
	private List<AssessGradeVo> assessGrades;
	/**
	 * 员工总数
	 */
	private int total = 0;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QryAssessResultsResponse{");
		sb.append ("assessGrades=").append (assessGrades);
		sb.append ('}');
		return sb.toString ();
	}
}
