/**
 * 文 件 名:  Rank
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/20 0020
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.database.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * <职级实体>
 *
 * @author zping
 * @version 2018/3/20 0020
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class Rank
{
	private int id;

	private String name;

	private String memo;

	private String createTime;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("Job{");
		sb.append ("id=").append (id);
		sb.append (", name='").append (name).append ('\'');
		sb.append (", memo='").append (memo).append ('\'');
		sb.append (", createTime='").append (createTime).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
