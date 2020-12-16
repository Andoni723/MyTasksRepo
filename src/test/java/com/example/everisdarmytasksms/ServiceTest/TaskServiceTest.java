package com.example.everisdarmytasksms.ServiceTest;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.everisdarmytasksms.Interface.TaskRepository;
import com.example.everisdarmytasksms.Service.TaskService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {
	
	@MockBean
	TaskRepository taskRepository;

	@Autowired
	TaskService taskService;
	
	public void test() {
		assertEquals(4, taskService.findAll().size());
	}
}
