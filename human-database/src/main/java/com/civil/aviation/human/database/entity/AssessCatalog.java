package com.civil.aviation.human.database.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssessCatalog
{
    private Integer id;

    private String name;

    private String createTime;

    private String memo;

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("AssessCatalog{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", createTime='").append(createTime).append('\'');
        sb.append(", memo='").append(memo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
