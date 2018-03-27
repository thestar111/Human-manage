/**
 * 文 件 名:  BasePageRequest
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.base;

import lombok.Getter;
import lombok.Setter;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/22 0022
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class BasePageRequest extends BaseRequest
{
	private int pageIndex = 0;

	private int pageSize = 10;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("BasePageRequest{");
		sb.append ("pageIndex=").append (pageIndex);
		sb.append (", pageSize=").append (pageSize);
		sb.append ('}');
		return sb.toString ();
	}
}
