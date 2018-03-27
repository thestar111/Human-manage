/**
 * 文 件 名:  MenuApiImpl
 * 版    权:  Quanten Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zping
 * 修改时间:  2018/3/22 0022
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.civil.aviation.human.provider.impl.menu;

import com.civil.aviation.human.api.menu.MenuApi;
import com.civil.aviation.human.api.menu.domain.MenuVo;
import com.civil.aviation.human.api.menu.request.*;
import com.civil.aviation.human.api.menu.response.QryMenuByIdResponse;
import com.civil.aviation.human.api.menu.response.QryMenuConditionResponse;
import com.civil.aviation.human.common.core.annotation.Api;
import com.civil.aviation.human.common.core.domain.Result;
import com.civil.aviation.human.database.entity.Menu;
import com.civil.aviation.human.database.mapper.MenuMapper;
import com.civil.aviation.human.provider.mapper.EntityMapperHandler;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <一句话功能简述> <功能详细描述>
 *
 * @author zping
 * @version 2018/3/22 0022
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Api
public class MenuApiImpl implements MenuApi
{

	private static final Logger LOGGER = LoggerFactory.getLogger (MenuApiImpl.class);

	@Autowired
	private MenuMapper menuMapper;

	/**
	 * 添加
	 *
	 * @param request
	 * @param createMenuRequest
	 * @return
	 */
	@Override
	public Result add (HttpServletRequest request, CreateMenuRequest createMenuRequest) throws Exception
	{
		if (null == createMenuRequest)
		{
			return Result.fail ("illage params");
		}
		Menu menu = null;
		EntityMapperHandler.INSTANCE.voToMenu (menu, createMenuRequest.getMenu ());
		int flag = menuMapper.add (menu);

		if (flag > 0)
		{
			return new Result ();
		}
		else
		{
			return Result.fail ("insert failed");
		}
	}

	/**
	 * 修改
	 *
	 * @param request
	 * @param modifyMenuRequest
	 * @return
	 */
	@Override
	public Result update (HttpServletRequest request, ModifyMenuRequest modifyMenuRequest) throws Exception
	{
		if (null == modifyMenuRequest)
		{
			return Result.fail ("illage params");
		}

		Menu menu = null;
		EntityMapperHandler.INSTANCE.voToMenu (menu, modifyMenuRequest.getMenu ());

		int flag = menuMapper.update (menu);

		if (flag > 0)
		{
			return new Result ();
		}
		else
		{
			return Result.fail ("modify failed");
		}
	}

	/**
	 * 删除
	 *
	 * @param request
	 * @param delMenuRequest
	 * @return
	 */
	@Override
	public Result delete (HttpServletRequest request, DelMenuRequest delMenuRequest) throws Exception
	{
		if (null == delMenuRequest.getMenuId ())
		{
			Result.fail ("menu id is null");
		}

		int flag = menuMapper.delete (delMenuRequest.getMenuId ());

		if (flag > 0)
		{
			return new Result ();
		}
		else
		{
			return Result.fail ("delete menu failed.");
		}
	}

	/**
	 * 查询
	 *
	 * @param request
	 * @param qryMenuByIdRequest
	 * @return
	 */
	@Override
	public QryMenuByIdResponse findById (HttpServletRequest request, QryMenuByIdRequest qryMenuByIdRequest)
			throws Exception
	{
		QryMenuByIdResponse qryMenuByIdResponse = null;

		if (null == qryMenuByIdRequest.getMenuId ())
		{
			return (QryMenuByIdResponse) Result.fail ("job id is null");
		}

		Menu menu = menuMapper.findById (qryMenuByIdRequest.getMenuId ());

		if (null != menu)
		{
			MenuVo menuVo = EntityMapperHandler.INSTANCE.menuTOVo (menu);
			qryMenuByIdResponse = new QryMenuByIdResponse ();
			qryMenuByIdResponse.setMenu (menuVo);
			return qryMenuByIdResponse;
		}
		else
		{
			return (QryMenuByIdResponse) Result.fail ("job not exist");
		}
	}

	/**
	 * 查询列表
	 *
	 * @param request
	 * @param qryMenuConditionRequest
	 * @return
	 */
	@Override
	public QryMenuConditionResponse queryConditionPage (HttpServletRequest request,
			QryMenuConditionRequest qryMenuConditionRequest) throws Exception
	{
		QryMenuConditionResponse qryJobConditionResponse = new QryMenuConditionResponse ();
		Map<String, Object> params = Maps.newHashMap ();

		if (! StringUtils.isEmpty (qryMenuConditionRequest.getMenuName ()))
		{
			params.put ("menuName", qryMenuConditionRequest.getMenuName ());
		}

		params.put ("pageIndex", qryMenuConditionRequest.getPageIndex ());
		params.put ("pageSize", qryMenuConditionRequest.getPageSize ());

		List<Menu> menus = menuMapper.queryAll (params);
		List<MenuVo> menuVos = null;
		if (! CollectionUtils.isEmpty (menus))
		{
			menuVos = Lists.newArrayList ();
			MenuVo menuVo = null;
			for (Menu menu : menus)
			{
				menuVo = EntityMapperHandler.INSTANCE.menuTOVo (menu);
				menuVos.add (menuVo);
			}
			qryJobConditionResponse.setMenus (menuVos);
			qryJobConditionResponse.setCount (menuMapper.queryCount (params));
			return qryJobConditionResponse;
		}
		else
		{
			qryJobConditionResponse.setMenus (menuVos);
			qryJobConditionResponse.setCount (0);
			return qryJobConditionResponse;
		}
	}
}
