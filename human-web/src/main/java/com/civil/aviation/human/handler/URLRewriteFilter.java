/**
 * 文 件 名:  SOPURLRewriteFilter
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/10/17 0017
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.handler;

import com.civil.aviation.human.common.core.exception.HumanException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.tuckey.web.filters.urlrewrite.Conf;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2017/10/17 0017
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class URLRewriteFilter extends UrlRewriteFilter
{
	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger (URLRewriteFilter.class);

	/**
	 * URL重写配置文件
	 */
	private static final String CONFIG_LOCATION = "urlrewrite.xml";

	@Autowired
	Environment env;

	@Override
	protected void loadUrlRewriter (FilterConfig filterConfig) throws ServletException
	{
		try
		{
			//Create a UrlRewrite Conf object with the injected resource
			ClassPathResource resource = new ClassPathResource (CONFIG_LOCATION);
			Conf conf = new Conf (filterConfig.getServletContext (), resource.getInputStream (),
					resource.getFilename (), "@@QT.SOP.PORTAL@@");
			checkConf (conf);
		}
		catch (IOException ex)
		{
			throw new HumanException ("999999", "Unable to load URL rewrite configuration file from " + CONFIG_LOCATION,
					ex);
		}
	}
}
