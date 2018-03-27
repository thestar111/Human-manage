/**
 * 文 件 名:  MapperConfig
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2017/7/10 0010
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <扫描Mapper，并注入SqlSessionFactory工厂类>
 *
 * @author zping
 * @version 2017/7/10 0010
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
public class MapperConfig
{

	private static final String BASE_PACK = "com.civil.aviation.human.database.mapper";

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer ()
	{
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer ();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName ("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage (BASE_PACK);
		return mapperScannerConfigurer;
	}
}
