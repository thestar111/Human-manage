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

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/4/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QryAssessResultByEmployResponse extends Result
{
	/**
	 * 考核成绩列表
	 */
	private AssessGradeVo assessGrade;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QryAssessResultByEmployResponse{");
		sb.append ("assessGrade=").append (assessGrade);
		sb.append ('}');
		return sb.toString ();
	}
}
