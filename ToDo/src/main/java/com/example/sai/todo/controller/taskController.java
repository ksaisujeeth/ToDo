package com.example.sai.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sai.todo.models.task;
import com.example.sai.todo.service.taskService;

@Controller
public class taskController {

	private final taskService taskService;
	
	public taskController(taskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping()
	public String getTask(Model model) {
		List<task> task = taskService.getAllTasks();
		model.addAttribute("tasks", task);
		return "tasks";
	}
	
	@PostMapping
	public String createTask(@RequestParam String title) {
		taskService.createTask(title);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteTask(@PathVariable Long id) {
		taskService.deleteTask(id);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/toggle")
	public String toggleTask(@PathVariable Long id) {
		taskService.toggleTask(id);
		return "redirect:/";
	}
}






