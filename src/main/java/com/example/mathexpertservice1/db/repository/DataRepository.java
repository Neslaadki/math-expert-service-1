package com.example.mathexpertservice1.db.repository;

import com.example.mathexpertservice1.db.model.Data;
import com.example.mathexpertservice1.db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DataRepository extends JpaRepository<Data, UUID> {
    List<Data> findByUser(User user);
}
