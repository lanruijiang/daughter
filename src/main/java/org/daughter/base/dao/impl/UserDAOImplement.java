package org.daughter.base.dao.impl;

import org.daughter.base.dao.UserDAO;
import org.daughter.base.mapper.UserDAOMapper;
import org.daughter.base.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Controller("UserDAO")
public class UserDAOImplement implements UserDAO {

    @Autowired
    private UserDAOMapper userDAOMapper;

    public UserDAOImplement() {

    }

    @Override
    @Transactional
    public boolean userRegist(Users users) {
        boolean b = userDAOMapper.userRegist( users );
        return b;
    }

    @Override
    public Users userLogin(Users users) {
        users = userDAOMapper.userLogin( users );
        return users;
    }

    @Override
    @Transactional
    public boolean userUpdate(Users users) {
        boolean b = userDAOMapper.userUpdate( users );
        return b;
    }

    @Override
    public boolean userHeadCreate(Users users) {
        boolean b = userDAOMapper.userHeadCreate( users );
        return b;
    }

    @Override
    public Users getUsesDetailById(int userId) {
        Users users = userDAOMapper.getUsesDetailById( userId );
        return users;
    }
}
