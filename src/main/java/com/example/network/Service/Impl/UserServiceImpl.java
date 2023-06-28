package com.example.network.Service.Impl;

import com.example.network.DAO.UserRepository;
import com.example.network.PO.User;
import com.example.network.Service.UserService;
import com.example.network.VO.ResponseVO;
import com.example.network.VO.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final static String ACCOUNT_EXIST = "账号已存在";
    private final static String UPDATE_ERROR = "修改失败";
    private final static String USER_NOTEXIST = "用户不存在";

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseVO registerAccount(UserVO userVO) {
        User user = new User();
        BeanUtils.copyProperties(userVO, user);
        if (userRepository.getByName(user.getUserName()) != null)
            return ResponseVO.buildFailure(ACCOUNT_EXIST);

        userRepository.save(user);
        return ResponseVO.buildSuccess(userVO);
    }

    @Override
    public ResponseVO login(UserVO userVO) {
        User user = userRepository.getByName(userVO.getUserName());
        if (user == null) {
            return ResponseVO.buildFailure(USER_NOTEXIST);
        }
        if (user.getPassword().equals(userVO.getPassword())) {
            UserVO ret = new UserVO();
            BeanUtils.copyProperties(user, ret);
            return ResponseVO.buildSuccess(ret);
        } else {
            return ResponseVO.buildFailure("密码错误");
        }
    }

    @Override
    public ResponseVO addUser(UserVO userVO) {
        User user = new User();
        BeanUtils.copyProperties(userVO, user);
        return ResponseVO.buildSuccess(userRepository.save(user));
    }


    @Override
    public ResponseVO updateUserInfo(UserVO userVO) {
        User user = new User();
        BeanUtils.copyProperties(userVO, user);
        User old = userRepository.getUserById(user.getId());
        old.setUserName(user.getUserName())
                .setPassword(user.getPassword());
        userRepository.save(old);
        return ResponseVO.buildSuccess(userVO);
    }

    @Override
    public ResponseVO deleteUser(Integer userId) {
        User user = userRepository.getUserById(userId);
        if (user == null)
            return ResponseVO.buildFailure(USER_NOTEXIST);
        if (user.getUserType() == 1)//如果该用户为管理员用户
            return ResponseVO.buildFailure("操作不合法");
        userRepository.deleteUserById(userId);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO getAllUsers() {
        List<User> userList = userRepository.findAll();

        List<UserVO> resList = new ArrayList<>();
        for (User user : userList) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            resList.add(userVO);
        }
        return ResponseVO.buildSuccess(resList);
    }


}
