/**
 * 文 件 名:  AssessContent
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
 * <考核内容信息表>
 *
 * @author zping
 * @version 2018/3/30 0030
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AssessContent implements Serializable
{
	/**
	 * 业务编号
	 */
	private int id;

	/**
	 * 考核指标内容
	 */
	private String content;

	/**
	 * 分数
	 */
	private int grade;

	/**
	 * 考核分类编号
	 */
	private String catalog;

	/**
	 * 考核分类名称
	 */
	private String catalogName;

	/**
	 * 考核时间
	 */
	private String time;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AssessContent{");
		sb.append ("id=").append (id);
		sb.append (", content='").append (content).append ('\'');
		sb.append (", grade=").append (grade);
		sb.append (", catalog=").append (catalog);
		sb.append (", time='").append (time).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
