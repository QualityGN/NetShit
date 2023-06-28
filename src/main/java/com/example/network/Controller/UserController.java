package com.example.network.Controller;

import com.example.network.Service.UserService;
import com.example.network.VO.ResponseVO;
import com.example.network.VO.UserVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @PostMapping("addUser")
    public ResponseVO addUser(@RequestBody UserVO userVO) {
        return userService.addUser(userVO);
    }

    @PostMapping("updateUserInfo")
    public ResponseVO updateUserInfo(@RequestBody UserVO userVO) {
        return userService.updateUserInfo(userVO);
    }

    @PostMapping("/delete")
    public ResponseVO deleteUser(@RequestBody Integer userId) {
        return userService.deleteUser(userId);
    }

    @GetMapping("/getAllUsers")
    public ResponseVO getAllUsers() {
        try {
            return ResponseVO.buildSuccess(userService.getAllUsers());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.buildFailure("获取所有用户失败");
        }
    }


}
