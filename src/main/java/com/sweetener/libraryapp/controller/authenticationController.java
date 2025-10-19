package com.sweetener.libraryapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class authenticationController {

    @GetMapping("/login")
    public String loginForm() {

        return "loginform";
    }

    @GetMapping("/register")
    public String registerForm() {

        return "register";
    }
}
