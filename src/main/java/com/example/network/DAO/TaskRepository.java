package com.example.network.DAO;

import com.example.network.PO.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task getTaskById(Integer id);

    void deleteTaskById(Integer id);
}
