package com.civil.aviation.human.database.mapper;

import com.civil.aviation.human.database.entity.AssessCatalog;
import com.civil.aviation.human.database.entity.AssessCatalogRela;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AssessCatalogMapper
{
	/**
	 * 添加考核分类
	 *
	 * @param assessCatalog
	 * @return
	 */
	int add (AssessCatalog assessCatalog);

	/**
	 * 添加考核主题分类关系
	 *
	 * @param assessCatalogRelas
	 * @return
	 */
	int addCatalogRela (List<AssessCatalogRela> assessCatalogRelas);

	/**
	 * 根据考核主题编号查询考核分类信息
	 *
	 * @param topicId
	 * @return
	 */
	List<AssessCatalog> queryAssessCatalogByTopicId(String topicId);

	/**
	 * 修改考核分类
	 *
	 * @param assessCatalog
	 * @return
	 */
	int modify (AssessCatalog assessCatalog);

	/**
	 * 删除考核分类
	 *
	 * @param catalogId
	 * @return
	 */
	int delete (String catalogId);

	/**
	 * 删除考核主题分类关系
	 *
	 * @param topicId
	 * @return
	 */
	int deleteCatalogRelas (String topicId);

	/**
	 * 删除考核主题分类关系
	 *
	 * @param topicId
	 * @return
	 */
	int deleteCatalogRela (@Param ("topicId") String topicId, @Param ("catalogId") String catalogId);

	/**
	 * 根据编号查询
	 *
	 * @param assessCatalogId
	 * @return
	 */
	AssessCatalog queryCatalogById (String assessCatalogId);

	/**
	 * 查询考核分类列表
	 *
	 * @param params
	 * @return
	 */
	List<AssessCatalog> queryList (Map<String, Object> params);

	/**
	 * 查询考核分类总数
	 *
	 * @param params
	 * @return
	 */
	int queryCount (Map<String, Object> params);
}
