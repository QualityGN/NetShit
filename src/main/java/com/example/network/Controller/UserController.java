package com.example.network.Controller;

import com.example.network.Service.UserService;
import com.example.network.VO.ResponseVO;
import com.example.network.VO.UserVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/register")
    public ResponseVO register(@RequestBody UserVO userVO) {
        return userService.registerAccount(userVO);
    }

    @PostMapping("/login")
    public ResponseVO login(@RequestBody UserVO userVO) {
        return userService.login(userVO);
    }

    @PostMapping("updateUserInfo")
    public ResponseVO updateUserInfo(@RequestBody UserVO userVO) {
        return userService.updateUserInfo(userVO);
    }

    @PostMapping("/delete")
    public ResponseVO deleteUser(@RequestBody Integer userId) {
        return userService.deleteUser(userId);
    }



}
