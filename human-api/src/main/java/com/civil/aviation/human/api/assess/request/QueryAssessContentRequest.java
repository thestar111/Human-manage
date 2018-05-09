package com.civil.aviation.human.api.assess.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryAssessContentRequest
{
	/**
	 * 考核内容编号
	 */
	private String assessContentId;

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("QueryAssessContentRequest{");
		sb.append ("assessContentId=").append (assessContentId);
		sb.append ('}');
		return sb.toString ();
	}
}
