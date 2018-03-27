/**
 * 文 件 名:  DataSource
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/10 0010
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2017/7/10 0010
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties (prefix = "spring.datasource")
public class DataSource
{
	private String url;

	private String username;

	private String password;

	private String driverClassName;

	private String filters;

	private String connectionProperties;

	private String validationQuery;

	private Boolean testWhileIdle;

	private Boolean testOnBorrow;

	private Boolean testOnReturn;

	private Boolean poolPreparedStatements;

	private Integer maxWait;

	private Integer maxActive;

	private Integer minIdle;

	private Integer initialSize;

	private Integer timeBetweenEvictionRunsMillis;

	private Integer minEvictableIdleTimeMillis;

	private Integer maxPoolPreparedStatementPerConnectionSize;

	@Bean
	public DruidDataSource druidDataSource ()
	{

		DruidDataSource dataSource = new DruidDataSource ();
		dataSource.setUrl (this.getUrl ());
		dataSource.setUsername (this.getUsername ());
		dataSource.setPassword (this.getPassword ());

		if (this.getInitialSize ().intValue () > 0)
		{
			dataSource.setInitialSize (this.getInitialSize ().intValue ());
		}

		if (this.getMinIdle ().intValue () > 0)
		{
			dataSource.setMinIdle (this.getMinIdle ().intValue ());
		}

		if (this.getMaxActive ().intValue () > 0)
		{
			dataSource.setMaxActive (this.getMaxActive ().intValue ());
		}

		if (this.getTestOnBorrow () != null)
		{
			dataSource.setTestOnBorrow (this.getTestOnBorrow ().booleanValue ());
		}

		if (this.getMaxWait ().intValue () > 0)
		{
			dataSource.setMaxWait (this.getMaxWait ().intValue ());
		}

		if (this.getTimeBetweenEvictionRunsMillis ().intValue () > 0)
		{
			dataSource.setTimeBetweenEvictionRunsMillis (this.getTimeBetweenEvictionRunsMillis ().intValue ());
		}

		if (this.getMinEvictableIdleTimeMillis ().intValue () > 0)
		{
			dataSource.setMinEvictableIdleTimeMillis (this.getMinEvictableIdleTimeMillis ().intValue ());
		}

		if (this.getValidationQuery () != null)
		{
			dataSource.setValidationQuery (this.getValidationQuery ());
		}

		if (this.getTestWhileIdle () != null)
		{
			dataSource.setTestWhileIdle (this.getTestWhileIdle ().booleanValue ());
		}

		if (this.getTestOnReturn () != null)
		{
			dataSource.setTestOnReturn (this.getTestOnReturn ().booleanValue ());
		}

		if (this.getPoolPreparedStatements () != null)
		{
			dataSource.setPoolPreparedStatements (this.getPoolPreparedStatements ().booleanValue ());
		}

		if (this.getMaxPoolPreparedStatementPerConnectionSize ().intValue () > 0)
		{
			dataSource.setMaxPoolPreparedStatementPerConnectionSize (
					this.getMaxPoolPreparedStatementPerConnectionSize ().intValue ());
		}

		if (this.getFilters () != null)
		{
			try
			{
				dataSource.setFilters (this.getFilters ());
			}
			catch (SQLException e)
			{
				e.printStackTrace ();
			}
		}

		if (this.getConnectionProperties () != null)
		{
			dataSource.setConnectionProperties (this.getConnectionProperties ());
		}

		try
		{
			dataSource.init ();
		}
		catch (SQLException e)
		{
			throw new RuntimeException (e);
		}

		/*
		DruidDataSource dataSource = new DruidDataSource ();
		dataSource.setUrl (url);
		dataSource.setDriverClassName (driverClassName);
		dataSource.setPassword (password);
		dataSource.setUsername (username);
		*/

		return dataSource;
	}

	@Override
	public String toString ()
	{
		final StringBuffer sb = new StringBuffer ("DataSource{");
		sb.append ("driverClassName='").append (driverClassName).append ('\'');
		sb.append (", url='").append (url).append ('\'');
		sb.append (", username='").append (username).append ('\'');
		sb.append (", password='").append (password).append ('\'');
		sb.append ('}');
		return sb.toString ();
	}
}
