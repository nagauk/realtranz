package com.unr.realtranz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/***
 **@Author:Nagaraju Ukkalam
 @Version:1.0
 @Date:15-12-2022 12:45
 **/
@Configuration
public class SimpleLogoutHandler implements LogoutHandler {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletResponse response;
    public SimpleLogoutHandler(){
        logout(request,response, SecurityContextHolder.getContext().getAuthentication());
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if(null != request){
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
        }

        SecurityContext context = SecurityContextHolder.getContext();
        SecurityContextHolder.clearContext();
        context.setAuthentication(null);
    }
}
