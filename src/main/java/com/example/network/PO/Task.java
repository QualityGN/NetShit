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
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; //任务主键

    @Column(name = "user_id")
    private Integer userId;//创建人id

    @Column(name = "timestamp")
    private String timestamp;//创建时间

    @Column(name = "task_description")
    private String taskDescription;//任务描述

    @Column(name = "test_description")
    private String testDescription;//测试用例描述

}
