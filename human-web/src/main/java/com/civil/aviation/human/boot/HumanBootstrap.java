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
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
	 * 加载自定义响应消息属性文件
	 *
	 * @return
	 */
	/*@Bean
	public MessageSource messageSource ()
	{
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource ();
		messageSource.setBasenames ("classpath:messages");
		messageSource.setDefaultEncoding ("UTF-8");
		messageSource.setAlwaysUseMessageFormat (true);
		messageSource.setCacheSeconds (60);
		return messageSource;
	}

	*//**
	 * 设置快速验证返回失败模式
	 *
	 * @return
	 *//*
	@Bean
	public Validator validator ()
	{
		ValidatorFactory validatorFactory = Validation.byProvider (HibernateValidator.class).configure ()
				.addProperty ("hibernate.validator.fail_fast", "true").buildValidatorFactory ();
		Validator validator = validatorFactory.getValidator ();
		return validator;
	}

	*//**
	 * 自定义 Validator，注入 messageSource
	 *
	 * @return
	 *//*
	@Bean
	public LocalValidatorFactoryBean defaultValidator ()
	{
		LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean ();
		factoryBean.setValidationMessageSource (messageSource ());
		return factoryBean;
	}*/

	public static void main (String[] args)
	{
		SpringApplication.run (HumanBootstrap.class, args);
	}
}
