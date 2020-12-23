package com.example.everisdarmytasksms.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.everisdarmytasksms.Entity.tasks;
import com.example.everisdarmytasksms.Interface.TaskRepository;

@Service
public class TaskService {
	
		@Autowired
		private TaskRepository taskRepository;

		public List<tasks> findAll(){
			
			var it = taskRepository.findAll();
			
			var tasks = new ArrayList<tasks>();
			it.forEach(task -> tasks.add(task));
			
			return tasks;
		}
		
		public Optional<tasks> searchById(int id) {
			Optional<tasks> task = taskRepository.findById(id);
			return task;
		}
		
		public Long count() {
			return taskRepository.count();
		}
		
		public void deleteById(Integer taskId) {
			taskRepository.deleteById(taskId);
		}
		
		public tasks saveByEntity(tasks task) {
			return taskRepository.save(task);
		}
		
		public void update(tasks taskUpdated) {
			int id = taskUpdated.getId();
			if(taskRepository.findById(id).isPresent()) {
				tasks taskToUpdate = new tasks();
				taskToUpdate.setId(taskUpdated.getId());
				taskToUpdate.setDescription(taskUpdated.getDescription());
				taskToUpdate.setStatus(taskUpdated.getStatus());
				System.out.println(taskToUpdate.toString());
				taskRepository.save(taskToUpdate);
			}
		}
		
}
