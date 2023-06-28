package com.example.network.DAO;

import com.example.network.PO.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getByName(String name);
    User getUserById(Integer id);
    void deleteUserById(Integer id);
}
