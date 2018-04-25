/**
 * 文 件 名:  AssessResult
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/30 0030
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.database.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <考核成绩结果信息实体>
 *
 * @author zping
 * @version 2018/3/30 0030
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AssessResult implements Serializable
{

	/**
	 * 业务编号
	 */
	private int id;

	/**
	 * 员工编号
	 */
	private String employee;

	/**
	 * 考核主题编号
	 */
	private String topic;

	/**
	 * 权重
	 */
	private int weight;

	/**
	 * 分数
	 */
	private double score;

	/**
	 * 评论人
	 */
	private String discussant;

	/**
	 * 时间
	 */
	private String time;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AssessResult{");
		sb.append ("id=").append (id);
		sb.append (", employee='").append (employee).append ('\'');
		sb.append (", topic=").append (topic);
		sb.append (", weight=").append (weight);
		sb.append (", score=").append (score);
		sb.append (", time='").append (time).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
