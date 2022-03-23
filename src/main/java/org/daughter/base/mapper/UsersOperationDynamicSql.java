package org.daughter.base.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.daughter.base.model.Users;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class UsersOperationDynamicSql {
    public String userUpdateDynamicSQL(Users users) {
        String sql = new SQL() {{
            UPDATE( "users" );
            if (users.getUserDescribe() != null) {
                SET( "userDescribe = #{userDescribe}" );
            } else if (users.getUserName() != null) {
                SET( "userName = #{userName}" );
            } else if (users.getUserPassword() != null) {
                SET( "userPassword = #{userPassword}" );
            }
            WHERE( "userId = #{userId}" );
        }}.toString();
        return sql;
    }
}
