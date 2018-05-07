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

import com.civil.aviation.human.api.assess.domain.AssessContentVo;
import com.civil.aviation.human.api.base.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <添加考核内容>
 *
 * @author zping
 * @version 2018/5/7 0007
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class CreateAssessContentRequest extends BaseRequest
{

	/**
	 * 考核内容信息
	 */
	private List<AssessContentVo> assessContents;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("CreateAssessContentRequest{");
		sb.append ("assessContents=").append (assessContents);
		sb.append ('}');
		return sb.toString ();
	}
}
