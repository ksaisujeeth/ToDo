package com.example.sai.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sai.todo.models.task;

public interface taskRepository extends JpaRepository<task, Long> {

}
