/**
 * 文 件 名:  HumanBootstrap
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.boot;

import com.civil.aviation.human.config.HumanConfiguration;
import com.civil.aviation.human.handler.URLRewriteFilter;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@SpringBootApplication
@ComponentScan ("com.civil.aviation.human")
public class HumanBootstrap
{

	/**
	 * 添加配置Jersey启动类
	 *
	 * @return
	 */
	@Bean
	public ServletRegistrationBean servletRegistrationBean ()
	{
		ServletRegistrationBean registrationBean = new ServletRegistrationBean (new ServletContainer (), "/human/*");
		registrationBean
				.addInitParameter (ServletProperties.JAXRS_APPLICATION_CLASS, HumanConfiguration.class.getName ());
		return registrationBean;
	}

	/**
	 * 添加URL重写Filter
	 *
	 * @return
	 */
	@Bean
	public FilterRegistrationBean registrationBean ()
	{
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean ();
		filterRegistrationBean.setFilter (new URLRewriteFilter ());
		return filterRegistrationBean;
	}

	public static void main (String[] args)
	{
		SpringApplication.run (HumanBootstrap.class, args);
	}
}
