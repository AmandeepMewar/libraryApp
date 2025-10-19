package com.sweetener.libraryapp.rest;

import com.sweetener.libraryapp.entity.User;
import com.sweetener.libraryapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User theUser) {

        theUser.setUserId(0);

        User dbUser = userService.save(theUser);

        return dbUser;
    }

}
