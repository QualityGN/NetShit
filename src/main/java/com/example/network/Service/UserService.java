package com.example.network.Service;

import com.example.network.VO.ResponseVO;
import com.example.network.VO.UserVO;

public interface UserService {
    /**
     * 用户注册
     *
     * @param userVO 用户信息
     */
    ResponseVO registerAccount(UserVO userVO);

    /**
     * 用户登录
     *
     * @param userVO 用户信息
     */
    ResponseVO login(UserVO userVO);


    /**
     * 管理员添加普通用户
     *
     * @param userVO 用户信息
     */
    ResponseVO addUser(UserVO userVO);

    /**
     * 用户信息修改
     *
     * @param userVO 用户信息
     */
    ResponseVO updateUserInfo(UserVO userVO);

    /**
     * 管理员删除普通用户
     *
     * @param userId 普通用户id
     */
    ResponseVO deleteUser(Integer userId);

    ResponseVO getAllUsers();
}
