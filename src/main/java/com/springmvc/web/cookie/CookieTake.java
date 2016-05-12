package com.springmvc.web.cookie;

import org.springframework.ui.ModelMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by guanghaoshao on 16/1/18.
 */
public class CookieTake {
    public static void cookie(ModelMap map, HttpServletRequest request) {
        if(request.getSession().getAttribute("username")!=null){
            map.put("name","欢迎"+request.getSession().getAttribute("username"));
            System.out.println("匹配");
        }else{
            System.out.println("不匹配");
            map.put("name","");
        }
    }
}
