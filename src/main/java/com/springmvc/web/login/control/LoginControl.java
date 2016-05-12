package com.springmvc.web.login.control;

import com.springmvc.web.cookie.MD5cookie;
import com.springmvc.web.login.entity.Login;
import com.springmvc.web.login.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by guanghaoshao on 15/11/23.
 */
@Controller
public class LoginControl {
    @Autowired
    LoginServer loginServer;


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String adminwelcome(){
        return "login";
    }
    @RequestMapping(value="/login/login" ,method = RequestMethod.POST)
    public String  loginwelcome(Login admin,HttpServletRequest httpServletRequest){

        if(loginServer.listContact(admin)){

            httpServletRequest.getSession().setAttribute("shao", admin.getUsername());

            System.out.println("shaoguanghao");

            return "redirect:/starter";
        }
            return "login";
    }
}
