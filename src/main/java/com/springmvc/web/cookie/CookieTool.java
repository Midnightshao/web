package com.springmvc.web.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guanghaoshao on 15/11/25.
 */
public class CookieTool {
    public static void addCookie(HttpServletRequest request,HttpServletResponse response,String name,String value,int maxAge){

        Cookie cookie = new Cookie(name,value);

        cookie.setPath(request.getContextPath());

        if(maxAge>0){
            cookie.setMaxAge(maxAge);
        }

        response.addCookie(cookie);
    }

    public static Cookie getCookieByName(HttpServletRequest request,String name){
        Map<String,Cookie> cookieMap = ReadCookieMap(request);
        if(cookieMap.containsKey(name)){
            Cookie cookie = (Cookie)cookieMap.get(name);
            return cookie;
        }else{
            return null;
        }
    }

    private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

}
