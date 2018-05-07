/**
 * 文 件 名:  AssessCatalogRela
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/7 0007
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.database.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/5/7 0007
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class AssessCatalogRela implements Serializable
{
	/**
	 * 业务编号
	 */
	private Integer id;
	/**
	 * 主题编号
	 */
	private String topicId;
	/**
	 * 考核分类编号
	 */
	private String assessCatalogId;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("AssessCatalogRela{");
		sb.append ("id=").append (id);
		sb.append (", topicId='").append (topicId).append ('\'');
		sb.append (", assessCatalogId='").append (assessCatalogId).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
