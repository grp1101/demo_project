package com.example.vue_chat_server.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("LoginSuccessHandler 실행 ");
        System.out.println(authentication.getName() + " 님 반갑습니다.");

        //redirect POST
        //response.sendRedirect("/api/");

        //forward (getmapping 요청이 안되고 postmapping으로 들어감)
        RequestDispatcher requestDispatehcer = request.getRequestDispatcher("/api/");
        requestDispatehcer.forward(request, response);
    }
}
