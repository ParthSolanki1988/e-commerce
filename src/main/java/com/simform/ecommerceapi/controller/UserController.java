package com.simform.ecommerceapi.controller;

import com.simform.ecommerceapi.dto.UserDto;
import com.simform.ecommerceapi.entity.User;
import com.simform.ecommerceapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDto addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping
    public UserDto updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
    }

}
