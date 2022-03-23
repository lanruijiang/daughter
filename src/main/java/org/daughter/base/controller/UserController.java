package org.daughter.base.controller;

import org.daughter.base.dao.UserDAO;
import org.daughter.base.dao.sources.UpdateParamBase;
import org.daughter.base.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    @Qualifier("UserDAO")
    public UserDAO userDAO;
    private String path = null;

    /**
     * 登录 Controller
     *
     * @param users
     * @param model
     * @return
     */
    @RequestMapping("/userRegist")
    public String UserRegistController(Users users, Model model) {

        boolean b = userDAO.userRegist( users );
        if (b) {
            path = "/user/login";
        } else {
            model.addAttribute( "msg", "注册失败请重新注册" );
            path = "/user/regist";
        }
        return path;
    }

    /**
     * 登录Controller
     *
     * @param users
     * @param model
     * @return
     */
    @RequestMapping("/userLogin")
    public String userLoginController(Users users, HttpSession session, Model model) {
        users = userDAO.userLogin( users );
        if (users != null) {
            session.setAttribute( "users", users );
            path = "/main/index";
        } else {
            model.addAttribute( "msg", "登录失败请重新登录" );
            path = "/users/login";
        }
        return path;
    }

    /**
     * 修改信息Controller
     *
     * @param users
     * @param model
     * @return
     */
    @RequestMapping("/userUpdate")
    public String UserUpdateController(Users users, Model model , HttpSession session) {
        Users u = (Users)session.getAttribute( "users" );
        int userId = u.getUserId();
        users.setUserId( userId);
        boolean b = userDAO.userUpdate( users );

        if (b) {
            users = userDAO.getUsesDetailById( userId );
            session.setAttribute( "users" , users);
            path = "/users/userStyle";
        } else {
            model.addAttribute( "msg", "修改失败请重新登录" );
            path = "/users/login";
        }
        return path;
    }

    /**
     * 更换头像Controller
     *
     * @param file
     * @param model
     * @param  session
     * @return
     */
    @RequestMapping("/userHeadCreate")
    public String UserHeadCreateController(@RequestParam("userHead") MultipartFile file, Model model, HttpSession session) {

        boolean b = false;
        Users users = (Users) session.getAttribute( "users" );
        String fileName = file.getOriginalFilename();
//        users.setUserHead( fileName );
        String path = UpdateParamBase.headURL;

        File filePath = new File( path );
        if (!filePath.exists()) {
            filePath.mkdirs();
        } else {
            String imageName = users.getUserHead();
            if (imageName != null){
                File fileDisk = new File( path + imageName );
                fileDisk.delete();
            }
        }

        try {
            String uuid = UUID.randomUUID().toString();
            fileName = uuid + fileName;
            file.transferTo( new File( path + fileName ) );
            users.setUserHead( fileName);
            b = userDAO.userHeadCreate( users );
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (b) {
            session.setAttribute( "users" , users );
            path = "/users/userStyle";
        } else {
            model.addAttribute( "msg", "修改失败请重新登录" );
            path = "/users/login";
        }
        return path;
    }

}
