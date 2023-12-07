package com.example.work1.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/list")
    public UserResponse list(@RequestBody UserRequest userRequest) {
        return userService.listusers(userRequest);
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponse> add(@RequestBody UserRequest userRequest) {
        return userService.adduser(userRequest);
    }

    @PutMapping("/update1")
    public ResponseEntity<UserResponse> update1(@RequestBody UserRequest userRequest) {

        return userService.update1(userRequest);
    }

    @PutMapping("/update2")
    public ResponseEntity<UserResponse> update2(@RequestBody UserRequest userRequest) {

        return userService.update2(userRequest);
    }

    @GetMapping("getAllUsers")
    public Iterable<MyUser> getAllUsers(@RequestBody UserRequest userRequest) {
        return userService.getAllUsers(userRequest);
    }


}
