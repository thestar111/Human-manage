package com.civil.aviation.human.api.assess.request;

import com.civil.aviation.human.api.assess.domain.AssessCatalogVo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyAssessCatalogRequest
{
    private AssessCatalogVo assessCatalog;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("CreateAssessCatalogRequest{");
        sb.append("assessCatalog=").append(assessCatalog);
        sb.append('}');
        return sb.toString();
    }
}
