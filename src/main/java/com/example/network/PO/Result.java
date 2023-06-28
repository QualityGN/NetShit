package com.example.network.PO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@Accessors(chain = true)
@DynamicInsert
@DynamicUpdate
@Table(name = "result")
public class Result {//普通用户任务完成详情
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;//用户id

    @Column(name = "task_id")
    private Integer taskId;//任务id

    @Column(name = "score")
    private double score;

    @Column(name = "file_path")
    private String filePath;//保存的配置文件
}
