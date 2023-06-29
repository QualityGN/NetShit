package com.example.network.Service.Impl;

import com.example.network.DAO.ResultRepository;
import com.example.network.DAO.TaskRepository;
import com.example.network.PO.Result;
import com.example.network.PO.Task;
import com.example.network.Service.TaskService;
import com.example.network.VO.ResponseVO;
import com.example.network.VO.TaskVO;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    private final static String TASK_NOEXIST = "任务不存在";

    @Resource
    TaskRepository taskRepository;
    @Resource
    ResultRepository resultRepository;

    @Override
    public ResponseVO create(TaskVO taskVO) {
        Task task = new Task();
        BeanUtils.copyProperties(taskVO, task);
        return ResponseVO.buildSuccess(taskRepository.save(task));
    }

    @Override
    public ResponseVO delete(Integer taskId) {
        Task task = taskRepository.getTaskById(taskId);
        if (task == null)
            return ResponseVO.buildFailure(TASK_NOEXIST);
        taskRepository.deleteTaskById(taskId);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO retrieveTask(Integer userId, Integer taskId) {
        Result result = resultRepository.getResultByUserIdAndTaskId(userId, taskId);
        Task task = taskRepository.getTaskById(taskId);
        TaskVO taskVO = new TaskVO();
        BeanUtils.copyProperties(task, taskVO);
        if (result != null) {
            taskVO.setScore(result.getScore());
            taskVO.setFilePath(result.getFilePath());
        } else {
            taskVO.setScore(0.0);
            taskVO.setFilePath(null);
        }
        return ResponseVO.buildSuccess(taskVO);
    }

    @Override
    public ResponseVO getAllTasksById(Integer userId) {
        List<Task> taskList = taskRepository.findAll();

        List<TaskVO> resList = new ArrayList<>();
        for (Task task : taskList) {
            TaskVO taskVO = new TaskVO();
            BeanUtils.copyProperties(task, taskVO);
            Result result = resultRepository.getResultByUserIdAndTaskId(userId, task.getId());
            if (result != null) taskVO.setScore(result.getScore());
            else taskVO.setScore(0.0);
            resList.add(taskVO);
        }
        return ResponseVO.buildSuccess(resList);
    }

}
