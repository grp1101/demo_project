package com.example.vue_chat_server.controller;


import com.example.discord_clone_api.service.UserService;
import com.example.discord_clone_api.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 로그인 (defaultSuccessUrl으로 인해 토큰 저장 후, 이 요청으로 넘아는 것 같음
     * @param response
     * @return
     */
    @PostMapping ("/")
    public UserVo POSThome(HttpServletResponse response) { // 인증된 사용자의 정보를 보여줌
        logger.info("/api/ 시작");
        //실패 url을 설정하여 똑같이 getmapping을 만들고 해당 컨트롤러를 지나는지 확인 , 만약 지나면 인증이 성공되지 않아 해당 컨트롤러를 지나지 않은 것으로 판단
        //밑에 http redirect를 설정하여 외부주소로 설정할 수 있음
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();

        UserVo userVo = new UserVo();

        if(auth != null){

            String email = auth.getPrincipal().toString();
            userVo = userService.getUserByEmailInUservo(email);
            userVo.setPassword(""); // password는 보이지 않도록 null로 설정

            //cookie 생성
            Cookie cookie = new Cookie("auth", userVo.authority );
            cookie.setMaxAge(60 * 60); // 쿠키의 유효기간이 한시간
            cookie.setPath("/");
            response.addCookie(cookie);

        }

        logger.info("/api/ 종료");

        return userVo;
    }

    /**
     * 로그아웃
     * @return
     */
    @GetMapping("/logout")
    public Boolean logout() { // 로그 아웃

        logger.info("/logout 시작");

        Boolean result = true;

//        try {
//
//        } catch (Exception e) {
//            System.out.println("error: "+e);
//        }

        logger.info("/logout 종료");

        return result;
    }


}