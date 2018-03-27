/**
 * 文 件 名:  HumanConfiguration
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/19 0019
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.config;

import com.civil.aviation.human.common.core.annotation.Api;
import com.civil.aviation.human.handler.ExceptionHandler;
import com.civil.aviation.human.handler.GzipInterceptor;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.glassfish.jersey.server.validation.ValidationFeature;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

/**
 * <配置资源管理>
 *
 * @author zping
 * @version 2018/3/19 0019
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class HumanConfiguration extends ResourceConfig
{

	/**
	 * 资源实现接口
	 */
	private static final String RESOURCE_BASE_PACKAGE = "com.civil.aviation.human.provider.impl";

	public HumanConfiguration ()
	{
		register (RequestContextFilter.class);
		register (JacksonFeature.class);
		register (GzipInterceptor.class);
		register (ExceptionHandler.class);

		ClassPathScanningCandidateComponentProvider scan = new ClassPathScanningCandidateComponentProvider (false);

		scan.addIncludeFilter (new AnnotationTypeFilter (Api.class));
		scan.addIncludeFilter (new AnnotationTypeFilter (Provider.class));

		//将带有Path，Provider注解加入到资源中
		registerClasses (scan.findCandidateComponents (RESOURCE_BASE_PACKAGE).stream ()
				.map (beanDefinition -> ClassUtils
						.resolveClassName (beanDefinition.getBeanClassName (), this.getClassLoader ()))
				.collect (Collectors.toSet ()));

	}
}
