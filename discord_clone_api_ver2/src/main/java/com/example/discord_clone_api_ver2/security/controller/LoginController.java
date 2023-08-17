package com.example.discord_clone_api_ver2.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("api")
public class LoginController {
    final private  static Logger LOG = Logger.getGlobal();
    public  static  final  String SECURED_TEXT = "Hello from the secured resource!";

    @GetMapping("/login")
    public void login() {
        System.out.println("api/login start");
        LOG.info("GET successfully called on /login resource");
    }

    @GetMapping("/hello")
    public void hello() {
        System.out.println("HelloWorld");
    }


}
