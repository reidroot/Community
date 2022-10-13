package com.wxy.community.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

    /**
     * 获取cookie中的ticket的值
     * @param request
     * @param name
     * @return
     */
    public static String getValue(HttpServletRequest request, String name){

        if (request == null || name == null){
            throw new IllegalArgumentException("参数为空！");
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals(name))
                    return cookie.getValue();
            }
        }

        return null;
    }
}
