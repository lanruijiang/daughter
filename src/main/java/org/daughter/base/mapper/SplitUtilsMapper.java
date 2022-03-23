package org.daughter.base.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SplitUtilsMapper {
    @Select( "select count(*) from #{tableName}" )
    public int allRows(String tableName);

}
