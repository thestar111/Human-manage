package com.civil.aviation.human.api.assess.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssessCatalogVo
{
    private Integer id;

    private String name;

    private String createTime;

    private String memo;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("AssessCatalogVo{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", createTime='").append(createTime).append('\'');
        sb.append(", memo='").append(memo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
