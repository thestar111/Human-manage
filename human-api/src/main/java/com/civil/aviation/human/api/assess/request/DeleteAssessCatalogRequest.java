package com.civil.aviation.human.api.assess.request;

import com.civil.aviation.human.api.assess.domain.AssessCatalogVo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteAssessCatalogRequest
{
    private String assessCatalogId;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("DeleteAssessCatalogRequest{");
        sb.append("assessCatalogId=").append(assessCatalogId);
        sb.append('}');
        return sb.toString();
    }
}
