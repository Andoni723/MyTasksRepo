package com.example.everisdarmytasksms;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.everisdarmytasksms.Entity.tasks;
import com.example.everisdarmytasksms.Interface.TaskRepository;

public class DBRunner implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(DBRunner.class);
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	@Transactional
	public void run (String... args) throws Exception {
		
		logger.info("initializing tasks");
		
		var t1 = new tasks("Tarea numero 75","Pendiente");
		taskRepository.save(t1);
		
		var t2 = new tasks("Tarea numero 76","Pendiente");
		taskRepository.save(t2);
		
		var t3 = new tasks("Tarea numero 77","Pendiente");
		taskRepository.save(t3);
	}
	
}
