package com.example.everisdarmytasksms.ControllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.everisdarmytasksms.Entity.tasks;
import com.example.everisdarmytasksms.Service.TaskService;
import com.example.everisdarmytasksms.controller.TaskController;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TasksControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TaskService taskService;
	
	@Test
	public void allTasksTest() throws Exception{
		
		when(taskService.findAll()).thenReturn(
				Arrays.asList(
						new tasks(1,"Tarea numero uno","Completada"),
						new tasks(2,"Tarea numero dos","Pendiente"),
						new tasks(3,"Tarea numero tres","En progreso")));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/tasks")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":1,\"description\":\"Tarea numero uno\",\"status\":\"Completada\"},{\"id\":2,\"description\":\"Tarea numero dos\",\"status\":\"Pendiente\"},{\"id\":3,\"description\":\"Tarea numero tres\",\"status\":\"En progreso\"}]"))
				.andReturn();
		
	}
	
	@Test
	public void searchByIdTest() throws Exception{
		
		tasks respuesta = new tasks(65,"Tarea numero 65","Pendiente");
		Optional<tasks> task = Optional.of(respuesta);
		when(taskService.searchById(65)).thenReturn(task);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/tasks/65")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":65,\"description\":\"Tarea numero 65\",\"status\":\"Pendiente\"}"))
				.andReturn();
	}
	
//	@Test
//	public void insertTest() throws Exception{
//		
//		tasks respuesta = new tasks(65,"Tarea numero 65","Pendiente");
//		when(taskService.saveByEntity(Mockito.any(tasks.class))).thenReturn(respuesta);
//		
//		RequestBuilder request = MockMvcRequestBuilders
//				.post("/tasks/65")
//				.accept(MediaType.APPLICATION_JSON);
//		
//		MvcResult result = mockMvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().json("{\"id\":65,\"description\":\"Tarea numero 65\",\"status\":\"Pendiente\"}"))
//				.andReturn();
//		
//	}
	
}
