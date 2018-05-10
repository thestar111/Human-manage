/**
 * 文 件 名:  AssessTopicContent
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/10 0010
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.database.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/5/10 0010
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AssessTopicContent
{
	/**
	 * 业务编号
	 */
	private String id;

	/**
	 * 目标对象职级
	 */
	private Integer rank;

	/**
	 * 目标对象部门
	 */
	private Integer department;

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
	 * 考核内容
	 */
	private String assessContent;

	/**
	 * 分类内容
	 */
	private String catalogName;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AssessTopicContent{");
		sb.append ("id='").append (id).append ('\'');
		sb.append (", rank=").append (rank);
		sb.append (", department=").append (department);
		sb.append (", title='").append (title).append ('\'');
		sb.append (", startTime='").append (startTime).append ('\'');
		sb.append (", endTime='").append (endTime).append ('\'');
		sb.append (", assessContent='").append (assessContent).append ('\'');
		sb.append (", catalogName='").append (catalogName).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
