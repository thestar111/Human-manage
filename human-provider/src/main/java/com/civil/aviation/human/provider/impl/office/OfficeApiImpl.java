package com.civil.aviation.human.provider.impl.office;

import com.civil.aviation.human.api.office.OfficeApi;
import com.civil.aviation.human.api.office.domain.OfficeVo;
import com.civil.aviation.human.api.office.request.*;
import com.civil.aviation.human.api.office.response.QryOfficeByIdResponse;
import com.civil.aviation.human.api.office.response.QryOfficeResponse;
import com.civil.aviation.human.common.core.annotation.Api;
import com.civil.aviation.human.common.core.domain.Result;
import com.civil.aviation.human.database.entity.Office;
import com.civil.aviation.human.database.mapper.OfficeMapper;
import com.civil.aviation.human.provider.impl.user.UserApiImpl;
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
 * <科室接口实现>
 *
 * @author zping
 * @version 2018/3/20 0020
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Api
public class OfficeApiImpl implements OfficeApi
{

    /**
     * 日志记录器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger (UserApiImpl.class);

    @Autowired
    private OfficeMapper officeMapper;

    @Override
    public Result add(HttpServletRequest request, CreateOfficeRequest createOfficeRequest) throws Exception
    {
        if (null == createOfficeRequest || null == createOfficeRequest.getOfficeVo ())
        {
            return Result.fail ("illega Parameters.");
        }
        Office office = EntityMapperHandler.INSTANCE.officeToEntity (createOfficeRequest.getOfficeVo ());
        int flag = officeMapper.add (office);
        if (flag > 0)
        {
            return Result.success ("add office success.");
        }
        else
        {
            return Result.fail ("add office failed.");
        }
    }

    @Override
    public Result update(HttpServletRequest request, ModifyOfficeRequest modifyOfficeRequest) throws Exception
    {
        if (null == modifyOfficeRequest || null == modifyOfficeRequest.getOfficeVo ())
        {
            return Result.fail ("illega Parameters.");
        }
        Office office = EntityMapperHandler.INSTANCE.officeToEntity (modifyOfficeRequest.getOfficeVo ());
        int flag = officeMapper.modify (office);
        if (flag > 0)
        {
            return Result.success ("update office success.");
        }
        else
        {
            return Result.fail ("update office failed.");
        }
    }

    @Override
    public Result delete(HttpServletRequest request, DelOfficeRequest delOfficeRequest) throws Exception
    {
        if (null == delOfficeRequest.getOfficeId ())
        {
            return Result.fail ("office is null.");
        }

        int flag = officeMapper.delete(delOfficeRequest.getOfficeId());

        if (flag > 0)
        {
            return Result.success ("update office success.");
        }
        else
        {
            return Result.fail ("update office failed.");
        }
    }

    @Override
    public QryOfficeByIdResponse findById(HttpServletRequest request, QryOfficeByIdRequest qryOfficeByIdRequest) throws Exception
    {
        if (StringUtils.isEmpty(qryOfficeByIdRequest.getOfficeId ()))
        {
            return (QryOfficeByIdResponse) Result.fail ("office is null.");
        }

        Office office = officeMapper.findById(qryOfficeByIdRequest.getOfficeId());
        OfficeVo officeVo = null;
        if (null != office)
        {
            officeVo = EntityMapperHandler.INSTANCE.officeToVo(office);
            QryOfficeByIdResponse qryOfficeByIdResponse = new QryOfficeByIdResponse();
            qryOfficeByIdResponse.setOfficeVo(officeVo);
            return qryOfficeByIdResponse;
        }
        else
        {
            return (QryOfficeByIdResponse) Result.success ("office not exist.");
        }
    }

    @Override
    public QryOfficeResponse queryConditionPage(HttpServletRequest request, QryOfficeRequest qryOfficeRequest) throws Exception
    {
        QryOfficeResponse qryOfficeResponse = new QryOfficeResponse ();
        Map<String, Object> params = Maps.newHashMap ();
        if (null != qryOfficeRequest.getDeparmentId ())
        {
            params.put ("department", qryOfficeRequest.getDeparmentId ());
        }
        if (! StringUtils.isEmpty (qryOfficeRequest.getOfficeName ()))
        {
            params.put ("name", qryOfficeRequest.getOfficeName ());
        }
        params.put ("pageIndex", qryOfficeRequest.getPageIndex ());
        params.put ("pageSize", qryOfficeRequest.getPageSize ());

        List<Office> offices = officeMapper.findByCondition (params);
        List<OfficeVo> officeVos = null;
        if (! CollectionUtils.isEmpty (offices))
        {
            officeVos = Lists.newArrayList ();
            OfficeVo officeVo = null;
            for (Office office : offices)
            {
                officeVo = EntityMapperHandler.INSTANCE.officeToVo (office);
                officeVos.add (officeVo);
            }
            qryOfficeResponse.setOfficeVos (officeVos);
            qryOfficeResponse.setCount (officeMapper.findCountByCondition (params));
        }
        else
        {
            qryOfficeResponse.setOfficeVos (officeVos);
            qryOfficeResponse.setCount (0);
        }
        return qryOfficeResponse;
    }
}
