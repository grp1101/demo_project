package com.example.discord_clone_api_not_sec.controller;


import com.example.discord_clone_api_not_sec.service.UserService;
import com.example.discord_clone_api_not_sec.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    /*회원가입 저장*/
    @PostMapping("/signup")
    public int signup(@RequestBody UserVo userVo) { // 회원 가입

        System.out.println("/signup 실행됨");
          int insertCount = userService.signup(userVo);

          if(insertCount > 0){
              return 1;
          }else{
              return 2;
          }
    }

}