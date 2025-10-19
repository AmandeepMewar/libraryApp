package com.sweetener.libraryapp.controller;

import com.sweetener.libraryapp.entity.User;
import com.sweetener.libraryapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class userController {

    private UserService userService;

    public userController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/userlist")
    public String userlist(Model theModel) {

        List<User> theUsers = userService.findAll();

        theModel.addAttribute("users", theUsers);

        return "userlist";
    }
}
