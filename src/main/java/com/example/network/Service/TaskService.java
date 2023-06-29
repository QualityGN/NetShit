package com.example.network.Service;

import com.example.network.VO.ResponseVO;
import com.example.network.VO.TaskVO;

public interface TaskService {
    /**
     * 管理员添加任务
     *
     * @param taskVO 任务相关信息
     */
    ResponseVO create(TaskVO taskVO);

    ResponseVO delete(Integer taskId);

    /**
     * 用户查看具体某一拓扑任务
     *
     * @param userId 普通用户id
     * @param taskId 拓扑任务id
     */
    ResponseVO retrieveTask(Integer userId, Integer taskId);


    /**
     * 普通用户查看拓扑任务列表
     *
     * @param userId 普通用户id
     */
    ResponseVO getAllTasksById(Integer userId);

}
