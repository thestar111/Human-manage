/**
 * 文 件 名:  CreateAssessContentRequest
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/5/7 0007
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.assess.request;

import com.civil.aviation.human.api.base.BaseRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * <删除考核内容>
 *
 * @author zping
 * @version 2018/5/7 0007
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class DeleteAssessContentRequest extends BaseRequest
{

	/**
	 * 考核内容信息
	 */
	private String assessContentId;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("ModifyAssessContentRequest{");
		sb.append ("assessContentId=").append (assessContentId);
		sb.append ('}');
		return sb.toString ();
	}
}
