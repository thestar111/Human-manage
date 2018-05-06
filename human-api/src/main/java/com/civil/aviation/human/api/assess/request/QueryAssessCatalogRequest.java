package com.civil.aviation.human.api.assess.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryAssessCatalogRequest
{
    private String assessCatalogId;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("QueryAssessCatalogRequest{");
        sb.append("assessCatalogId=").append(assessCatalogId);
        sb.append('}');
        return sb.toString();
    }
}
