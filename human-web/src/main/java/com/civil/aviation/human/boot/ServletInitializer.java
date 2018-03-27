/**
 * 文 件 名:  ServletInitializer
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.boot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * <Servlet初始化类>
 *
 * @author zping
 * @version 2018/3/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ServletInitializer extends SpringBootServletInitializer
{
	/**
	 * Servlet初始化类
	 *
	 * @param builder
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder)
	{
		return builder.sources (HumanBootstrap.class);
	}
}
