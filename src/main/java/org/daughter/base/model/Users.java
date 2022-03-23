package org.daughter.base.model;

import lombok.*;

import java.util.Date;

/**
 * create table users ( userId int primary key auto_increment, userName
 * varchar(100), userPassword varchar(100), userEmail varchar(100) );
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    private Integer userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userDescribe;
    private Date userLoginTime;
    private String userHead;

    public Users(Integer userId , String userName) {
        this.userId = userId;
        this.userName = userName;
    }

}
