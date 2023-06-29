package com.example.network.DAO;

import com.example.network.PO.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Integer> {
    Result getResultByUserIdAndTaskId(Integer userId, Integer taskId);
}
