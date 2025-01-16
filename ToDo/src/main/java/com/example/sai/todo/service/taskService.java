package com.example.sai.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sai.todo.models.task;
import com.example.sai.todo.repository.taskRepository;

@Service
public class taskService {
	
	private final taskRepository taskRepository;
	
	public taskService(taskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<task> getAllTasks() {
		
		return taskRepository.findAll();
	}

	public void createTask(String title) {
		
		task task = new task();
		task.setTitle(title);
		task.setCompleted(false);
		taskRepository.save(task);

	}

	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

	public void toggleTask(Long id) {

		task task = taskRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid task id"));
		task.setCompleted(!task.isCompleted());
		taskRepository.save(task);
	}
	
	

}







