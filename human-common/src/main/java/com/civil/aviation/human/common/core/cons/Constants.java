/**
 * 文 件 名:  Constants
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/20 0020
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.common.core.cons;

/**
 * <常量定义>
 *
 * @author zping
 * @version 2018/3/20 0020
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Constants
{
	/**
	 * 媒体类型
	 */
	public interface MediaType
	{
		public static final String ENCODE_UTF8 = "UTF-8";
		public static final String APPLICATION_JSON_UTF8 = "application/json; charset=UTF-8";
	}

	/**
	 * 错误码
	 */
	public interface ResultCode
	{
		public static final String NOT_LOGIN = "999998";
		public static final String FAILED = "-1";
		public static final String SUCCESS = "0";
	}
}
