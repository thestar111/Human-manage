/**
 * 文 件 名:  QryAssessTopicResponse
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/4/2 0002
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.api.assess.response;

import com.civil.aviation.human.api.assess.domain.AssessContentVo;
import com.civil.aviation.human.common.core.domain.Result;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <查询考核内容返回对象>
 *
 * @author zping
 * @version 2018/4/2 0002
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
public class QryAssessContentListResponse extends Result
{
	/**
	 * 考核主题信息
	 */
	private List<AssessContentVo> assessContents;

	/**
	 * 总数
	 */
	private int count = 0;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QryAssessContentListResponse{");
		sb.append ("assessContents=").append (assessContents);
		sb.append ('}');
		return sb.toString ();
	}
}
