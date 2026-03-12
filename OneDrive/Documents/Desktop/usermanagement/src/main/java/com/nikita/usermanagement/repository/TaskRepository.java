package com.nikita.usermanagement.repository;

import com.nikita.usermanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}