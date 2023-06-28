package com.example.network.Controller;

import com.example.network.Service.TaskService;
import com.example.network.VO.ResponseVO;
import com.example.network.VO.TaskVO;
import com.example.network.VO.UserVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Resource
    TaskService taskService;

    @PostMapping("/create")
    public ResponseVO createTask(@RequestBody TaskVO taskVO) {
        return taskService.create(taskVO);
    }

    @PostMapping("/delete")
    public ResponseVO deleteTask(@RequestBody Integer taskId) {
        return taskService.delete(taskId);
    }
}
