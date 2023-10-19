package com.example.discord_clone_api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/access")
public class AccessController {

    private static final Logger logger = LoggerFactory.getLogger(AccessController.class);

    // 다운로드 페이지(쿠기 사용하기 위한 테스트 url controller)
    @GetMapping("/download_page")
    public void laod_download_page(HttpServletRequest request) throws IOException {

        logger.info("/access/download_page 시작");

        Authentication auth= SecurityContextHolder.getContext().getAuthentication();

        Cookie[] cookies=request.getCookies(); // 모든 쿠키 가져오기
        if(cookies!=null){
            for (Cookie c : cookies) {
                String name = c.getName(); // 쿠키 이름 가져오기
                String value = c.getValue(); // 쿠키 값 가져오기
//                if (name.equals("내가 찾으려는 쿠키 ID")) {
//                    return value;
//                }
            }
        }


        logger.info("/access/download_page 종료");

//        request.sendRedirect("http://localhost:8080/access/download_page.vue");
    }

    // 다운로드 페이지
    @PostMapping("/download_page")
    public void laod_download_page2() {

        logger.info("/access/download_page 시작");

        Authentication auth= SecurityContextHolder.getContext().getAuthentication();

        logger.info("/access/download_page 종료");

    }

}
