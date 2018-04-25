/**
 * 文 件 名:  AssessGradeVo
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.assess.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <员工考核评分展示>
 *
 * @author zping
 * @version 2018/4/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AssessGradeVo implements Serializable
{
	/**
	 * 员工编号
	 */
	private String employeeId;

	/**
	 * 员工名称
	 */
	private String employeeName;

	/**
	 * 考核主题编号
	 */
	private String topic;

	/**
	 * 上级分数
	 */
	private double higherUpScore;

	/**
	 * 下级分数
	 */
	private double lowerUpScore;

	/**
	 * 自评分数
	 */
	private double score;

	/**
	 * 同级分数
	 */
	private double vis_a_vis_score;

	/**
	 * 时间
	 */
	private String time;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AssessGradeVo{");
		sb.append ("employeeId='").append (employeeId).append ('\'');
		sb.append (", employeeName='").append (employeeName).append ('\'');
		sb.append (", topic='").append (topic).append ('\'');
		sb.append (", higherUpScore=").append (higherUpScore);
		sb.append (", lowerUpScore=").append (lowerUpScore);
		sb.append (", score=").append (score);
		sb.append (", vis_a_vis_score=").append (vis_a_vis_score);
		sb.append (", time='").append (time).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
