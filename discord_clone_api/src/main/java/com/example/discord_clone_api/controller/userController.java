package com.example.discord_clone_api.controller;


import com.example.discord_clone_api.service.UserService;
import com.example.discord_clone_api.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    /*홈화면 요청 (defaultSuccessUrl으로 인해 토근 저장 후, 이 요청으로 넘아는 것 같음*/
    @GetMapping("/")
    public String home(Model model) { // 인증된 사용자의 정보를 보여줌
        //실패 url을 설정하여 똑같이 getmapping을 만들고 해당 컨트롤러를 지나는지 확인 , 만약 지나면 인증이 성공되지 않아 해당 컨트롤러를 지나지 않은 것으로 판단
        //밑에 http redirect를 설정하여 외부주소로 설정할 수 있음
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("user", auth);

        Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // token에 저장되어 있는 인증된 사용자의 id 값

        UserVo userVo = userService.getUserById(id);
        userVo.setPassword(null); // password는 보이지 않도록 null로 설정
        model.addAttribute("user", userVo);
        return "redirect:http://localhost:8080/";
    }


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

//    @GetMapping("/")
//    public String home(Model model) { // 인증된 사용자의 정보를 보여줌
//        Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        // token에 저장되어 있는 인증된 사용자의 id 값
//
//        UserVo userVo = userService.getUserById(id);
//        userVo.setPassword(null); // password는 보이지 않도록 null로 설정
//        model.addAttribute("user", userVo);
//        return "home";
//    }


}