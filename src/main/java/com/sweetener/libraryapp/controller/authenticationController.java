package com.sweetener.libraryapp.controller;

import com.sweetener.libraryapp.entity.User;
import com.sweetener.libraryapp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class authenticationController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public authenticationController(UserService theUserService, PasswordEncoder thePasswordEncoder) {
        userService  = theUserService;
        passwordEncoder = thePasswordEncoder;
    }

    @GetMapping("/login")
    public String loginForm() {

        return "loginform";
    }

    @GetMapping("/register")
    public String registerForm(Model theModel) {

        User theUser = new User();
        theModel.addAttribute("user", theUser);

        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User theUser) {

        theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));
        userService.save(theUser);

        return "redirect:/login";
    }
}
