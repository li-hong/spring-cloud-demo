package com.dh.cloud.web;

import com.dh.cloud.domain.User;
import com.dh.cloud.domain.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private String profile = "hhh";


    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{name}")
    public User findByName(@PathVariable("name") String name) {
        try {
            User u = userService.findByName(name);
            return u;
        } catch (Exception e) {
            logger.error("ex=", e);
        }
        return null;
    }

    @GetMapping(value = "/users")
    public List<User> users() {
        return userService.findAll();
    }

    @GetMapping(value = "/profile")
    public String profile() {
        return profile;
    }
}
