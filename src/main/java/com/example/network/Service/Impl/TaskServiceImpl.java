package com.example.network.Service.Impl;

import com.example.network.DAO.TaskRepository;
import com.example.network.PO.Task;
import com.example.network.Service.TaskService;
import com.example.network.VO.ResponseVO;
import com.example.network.VO.TaskVO;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    private final static String TASK_NOEXIST = "任务不存在";

    @Resource
    TaskRepository taskRepository;

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

}
