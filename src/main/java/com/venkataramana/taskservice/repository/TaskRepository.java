package com.venkataramana.taskservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venkataramana.taskservice.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{

}
