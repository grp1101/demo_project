package com.example.discord_clone_api.controller;


import com.example.discord_clone_api.service.UserService;
import com.example.discord_clone_api.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    /*회원가입 저장*/
    @PostMapping("/signup")
    public UserVo signup(@RequestBody UserVo userVo) { // 회원 가입

        System.out.println("/signup 실행됨");

        int result = 0;

        try {

            result= userService.signup(userVo);

            if(result > 0){
                userVo.setResult(1);
            }else{
                userVo.setResult(0);
            }

        } catch (Exception e) {
            System.out.println("error: "+e);
        }

        return userVo;
    }

}