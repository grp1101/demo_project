package com.example.discord_clone_api.controller;


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
import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(SystemController.class);

    /**
     * 전체 유저 정보 조회하기
     * @return
     */
    @PostMapping ("/selectUserList")
    public List<UserVo> selectUserList() {
        logger.info("/selectUserList 시작");

        List<UserVo> userList= userService.getUserList();

        logger.info("/selectUserList 종료");

        return userList;
    }

    /**
     * 유저 권한 수정
     * @return
     */
    @PostMapping ("/UpdateUserAuth")
    public UserVo UpdateUserAuth(@RequestBody UserVo user) {
        logger.info("/UpdateUserAuth 시작");

        int UpdateUserCnt= userService.UpdateUser(user);

        UserVo oneUserList = new UserVo();
        if(UpdateUserCnt > 0){
            oneUserList = user;
        };

        logger.info("/UpdateUserAuth 종료");

        return oneUserList;
    }


}