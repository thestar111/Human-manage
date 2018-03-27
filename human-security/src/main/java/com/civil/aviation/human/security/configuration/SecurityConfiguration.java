/**
 * 文 件 名:  SecurityConfiguration
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/20 0020
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.security.configuration;

import com.google.common.collect.Maps;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <安全配置类>
 *
 * @author zping
 * @version 2018/3/20 0020
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
public class SecurityConfiguration
{

	/**
	 * Ehcache Xml
	 */
	private static final String AUTH_EHCACHE_XML = "classpath:ehcache-shiro.xml";

	/**
	 * 核心过滤器
	 *
	 * @param securityManager
	 * @return
	 */
	@Bean (name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter (SecurityManager securityManager)
	{
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean ();
		shiroFilterFactoryBean.setSecurityManager (securityManager);
		shiroFilterFactoryBean.setLoginUrl ("/login.jsp");
		shiroFilterFactoryBean.setSuccessUrl ("/index");

		//自定义拦截器做权限验证
		Map<String, Filter> filters = Maps.newLinkedHashMap ();
		filters.put ("online", onlineAccess ());
		//filters.put ("access", authAccess ());
		shiroFilterFactoryBean.setFilters (filters);

		//拦截URL
		Map<String, String> filterChain = new LinkedHashMap<> ();
		filterChain.put ("/human/system/login", "online");
		filterChain.put ("/human/system/regist", "online");
		filterChain.put ("/*.html", "online");

		shiroFilterFactoryBean.setFilterChainDefinitionMap (filterChain);
		return shiroFilterFactoryBean;
	}

	/**
	 * EhCache管理器
	 *
	 * @return
	 */
	@Bean
	public EhCacheManager ehCacheManager ()
	{
		EhCacheManager ehCacheManager = new EhCacheManager ();
		ehCacheManager.setCacheManagerConfigFile (AUTH_EHCACHE_XML);
		return ehCacheManager;
	}

	/**
	 * 权限授权服务管理器
	 *
	 * @return
	 */
	@Bean (name = "authorizationService")
	public AuthorizationService authorizationRealm ()
	{
		AuthorizationService authorizationService = new AuthorizationService ();
		authorizationService.setCacheManager (ehCacheManager ());
		return authorizationService;
	}

	/**
	 * 会话在线控制管理器
	 *
	 * @return
	 */
	@Bean (name = "online")
	public OnlineAccess onlineAccess ()
	{
		OnlineAccess online = new OnlineAccess ();
		return online;
	}

	/**
	 * 权限验证访问管理器
	 *
	 * @return
	 */
	@Bean (name = "access")
	public AuthAccess authAccess ()
	{
		AuthAccess authAccess = new AuthAccess ();
		return authAccess;
	}

	/**
	 * Bean生命周期管理器
	 *
	 * @return
	 */
	@Bean (name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor ()
	{
		return new LifecycleBeanPostProcessor ();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator ()
	{
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator ();
		creator.setProxyTargetClass (true);
		return creator;
	}

	/**
	 * 核心安全管理器
	 *
	 * @return
	 */
	@Bean (name = "securityManager")
	public SecurityManager securityManager ()
	{
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager ();
		securityManager.setRealm (authorizationRealm ());
		/* 用户授权/认证信息Cache, 采用EhCache 缓存 */
		securityManager.setCacheManager (ehCacheManager ());
		return securityManager;
	}

	/**
	 * 启用AOP注解
	 *
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor (SecurityManager securityManager)
	{
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor ();
		authorizationAttributeSourceAdvisor.setSecurityManager (securityManager);
		return authorizationAttributeSourceAdvisor;
	}
}
