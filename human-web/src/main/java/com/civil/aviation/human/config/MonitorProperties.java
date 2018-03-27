/**
 * 文 件 名:  MonitorProperties
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/21 0021
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <Durid监控属性>
 *
 * @author zping
 * @version 2018/3/21 0021
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties (prefix = "spring.datasource.monitor")
public class MonitorProperties
{
	private String druidStatView;
	private String druidWebStatFilter;
	private String allow;
	private String deny;
	private String loginUsername;
	private String loginPassword;
	private String exclusions;
	private String resetEnable;

	@Bean
	public ServletRegistrationBean druidStatViewServlet ()
	{
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean (new StatViewServlet (),
				this.getDruidStatView ());

		servletRegistrationBean.addInitParameter ("allow", this.getAllow ());

		servletRegistrationBean.addInitParameter ("deny", this.getDeny ());

		servletRegistrationBean.addInitParameter ("loginUsername", this.getLoginUsername ());
		servletRegistrationBean.addInitParameter ("loginPassword", this.getLoginPassword ());

		servletRegistrationBean.addInitParameter ("resetEnable", this.getResetEnable ());
		return servletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean druidStatFilter ()
	{
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean (new WebStatFilter (),
				new ServletRegistrationBean[0]);

		filterRegistrationBean.addUrlPatterns (this.getDruidWebStatFilter ());

		filterRegistrationBean.addInitParameter ("exclusions", this.getExclusions ());
		return filterRegistrationBean;
	}

	@Override
	public String toString ()
	{
		final StringBuilder sb = new StringBuilder ("MonitorProperties{");
		sb.append ("DruidStatView='").append (druidStatView).append ('\'');
		sb.append (", DruidWebStatFilter='").append (druidWebStatFilter).append ('\'');
		sb.append (", allow='").append (allow).append ('\'');
		sb.append (", deny='").append (deny).append ('\'');
		sb.append (", loginUsername='").append (loginUsername).append ('\'');
		sb.append (", loginPassword='").append (loginPassword).append ('\'');
		sb.append (", exclusions='").append (exclusions).append ('\'');
		sb.append (", resetEnable='").append (resetEnable).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
