package com.example.vue_chat_server.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.out.println("LoginFailureHandler 실행 : "+exception);

        //redirect POST
//        response.sendRedirect("/api/");

        //forward (getmapping 요청이 안되고 postmapping으로 들어감)
        RequestDispatcher requestDispatehcer = request.getRequestDispatcher("/api/");
        requestDispatehcer.forward(request, response);
    }
}
