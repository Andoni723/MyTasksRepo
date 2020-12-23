package com.example.everisdarmytasksms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.everisdarmytasksms.Entity.tasks;
import com.example.everisdarmytasksms.Service.TaskService;

@CrossOrigin(origins = "*")
@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public List<tasks> allTasks() {
		return taskService.findAll();
	}
	
	@RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
	public Optional<tasks> searchById(@PathVariable int id) {
		return taskService.searchById(id);
	}
	
	@RequestMapping(value = "/tasks/count", method = RequestMethod.GET)
	public Long count() {
		return taskService.count();
	}
	
	@RequestMapping(value = "/tasks/insert", method = RequestMethod.POST, consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public tasks insert(@RequestBody tasks task) {
		return taskService.saveByEntity(task);
	}
	
	@RequestMapping(value = "/tasks/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public void delete(@PathVariable String id) { 
		int taskId = Integer.parseInt(id);
		taskService.deleteById(taskId);
	}
	
	@RequestMapping(value = "/tasks/update", method = RequestMethod.POST, consumes = "application/json")
	public void update(@RequestBody tasks taskUpdated) {
		taskService.update(taskUpdated);
	}
	
}
