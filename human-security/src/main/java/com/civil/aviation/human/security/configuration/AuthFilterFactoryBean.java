/**
 * 文 件 名:  AuthFilterFactoryBean
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/11 0011
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.security.configuration;

import com.civil.aviation.human.common.core.exception.HumanException;
import com.google.common.collect.Sets;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;

/**
 * <自定义实现FilterFactoryBean工厂类>
 *
 * @author zping
 * @version 2017/7/11 0011
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class AuthFilterFactoryBean extends ShiroFilterFactoryBean
{
	/**
	 * 忽略请求集合
	 */
	private Set<String> ignoreExt;

	/**
	 * 默认构造器
	 */
	public AuthFilterFactoryBean ()
	{
		super ();
		ignoreExt = Sets.newHashSet ();
		ignoreExt.add (".jpg");
		ignoreExt.add (".png");
		ignoreExt.add (".js");
		ignoreExt.add (".css");
		ignoreExt.add (".html");
		ignoreExt.add (".gif");
	}

	@Override
	protected AbstractShiroFilter createInstance () throws Exception
	{
		SecurityManager securityManager = getSecurityManager ();

		if (null == securityManager)
		{
			throw new HumanException ("999999", "security Manager init error.");
		}

		if (! (securityManager instanceof WebSecurityManager))
		{
			throw new HumanException ("999999", "security Manager not implements WebSecurityManager.");
		}

		FilterChainManager filterChainManager = createFilterChainManager ();

		PathMatchingFilterChainResolver resolver = new PathMatchingFilterChainResolver ();
		resolver.setFilterChainManager (filterChainManager);

		return new CustomShiroFilter ((WebSecurityManager) securityManager, resolver);
	}

	/**
	 * 自定义ShiroFilter
	 */
	private final class CustomShiroFilter extends AbstractShiroFilter
	{

		protected CustomShiroFilter (WebSecurityManager webSecurityManager, FilterChainResolver resolver)
		{
			super ();
			if (null == webSecurityManager)
			{
				throw new HumanException ("999999", "webSecurityManager is null.");
			}

			setSecurityManager (webSecurityManager);

			if (null != resolver)
			{
				setFilterChainResolver (resolver);
			}
		}

		// 因为ShiroFilter 拦截所有请求（在上面我们配置了urlPattern 为 * ，当然你也可以在那里精确的添加要处理的路径，这样就不需要这个类了），
		// 而在每次请求里面都做了session的读取和更新访问时间等操作，这样在集群部署session共享的情况下，数量级的加大了处理量负载。
		// 所以我们这里将一些能忽略的请求忽略掉。
		// 当然如果你的集群系统使用了动静分离处理，静态资料的请求不会到Filter这个层面，便可以忽略。
		@Override
		protected void doFilterInternal (ServletRequest servletRequest, ServletResponse servletResponse,
				FilterChain chain) throws ServletException, IOException
		{
			HttpServletRequest request = (HttpServletRequest) servletRequest;

			super.doFilterInternal (servletRequest, servletResponse, chain);
		}
	}
}
