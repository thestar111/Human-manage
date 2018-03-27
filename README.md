# Human-manage 项目
## 项目基于Spring Boot框架搭建，环境搭建方便，快。部署方便，整个项目基于注解驱动，简洁干净

## 项目结构

项目名称     |     功能
-----------|-----------
human-common   | 公共模块
human-security | 系统权限配置模块
human-database | 系统数据库模块
human-api      | 资源接口定义模块
human-provider | 资源接口实现模块
human-web      | 系统启动打包模块

## 该项目涉及一下基础技术框架

基础框架    |      用途
-----------|--------------
Shiro      |    权限控制
Durid      |    数据源
MapStruct  |    实体映射
Jersey     |    Resultful接口实现
MyBatis    |    数据持久层实现
Lo4gj2     |    系统日志实现
Ehcache    |    系统缓存实现
Urlrewritefilter  |  页面路径重写配置


## 其中结合技术框架使用列子如下：


	1. 全局异常统一处理
	2. 业务日志追踪链log4j2+UUID+Jersey实现(集群环境或分布式服务中定位问题特别快)
	3. Durid数据源监控
	4. 自定义注解扫描资源接口
	5. 接口统一响应格式
