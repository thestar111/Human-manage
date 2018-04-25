/**
 * 文 件 名:  TopicVo
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/2 0002
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.assess.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <考核主题VO对象>
 *
 * @author zping
 * @version 2018/4/2 0002
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AssessTopicVo implements Serializable
{
	/**
	 * 业务编号
	 */
	private String topicId;

	/**
	 * 目标对象职级
	 */
	private Integer rankId;

	/**
	 * 目标对象部门
	 */
	private Integer departmentId;

	/**
	 * 考核标题
	 */
	private String title;

	/**
	 * 开始时间
	 */
	private String startTime;

	/**
	 * 结束时间
	 */
	private String endTime;

	/**
	 * 发布状态(0: 已发布  1：未发布)
	 */
	private Integer status = 0;

	/**
	 * 扩展字段1
	 */
	private String extend1;

	/**
	 * 扩展字段2
	 */
	private String extend2;

	/**
	 * 扩展字段3
	 */
	private String extend3;

	/**
	 * 扩展字段4
	 */
	private String extend4;

	/**
	 * 扩展字段5
	 */
	private String extend5;

	/**
	 * 扩展字段6
	 */
	private String extend6;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AssessTopicVo{");
		sb.append ("topicId='").append (topicId).append ('\'');
		sb.append (", rankId=").append (rankId);
		sb.append (", departmentId=").append (departmentId);
		sb.append (", title='").append (title).append ('\'');
		sb.append (", startTime='").append (startTime).append ('\'');
		sb.append (", endTime='").append (endTime).append ('\'');
		sb.append (", status=").append (status);
		sb.append (", extend1='").append (extend1).append ('\'');
		sb.append (", extend2='").append (extend2).append ('\'');
		sb.append (", extend3='").append (extend3).append ('\'');
		sb.append (", extend4='").append (extend4).append ('\'');
		sb.append (", extend5='").append (extend5).append ('\'');
		sb.append (", extend6='").append (extend6).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
