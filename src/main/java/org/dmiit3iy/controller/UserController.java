package org.dmiit3iy.controller;

import org.dmiit3iy.model.User;
import org.dmiit3iy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

public class UserController {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public User post(@RequestParam String userName, @RequestParam String password){
        User user = new User(userName, password);
        this.userService.add(user);
        return user;
    }
}
