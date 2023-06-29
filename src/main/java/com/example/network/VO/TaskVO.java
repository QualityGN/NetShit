package com.example.network.VO;

import lombok.Data;

@Data
public class TaskVO {
    private Integer id;
    private Integer userId;
    private String timestamp;
    private String taskDescription;
    private Integer taskType;
    private String testDescription;
    private Double score;
    private String filePath;
}
