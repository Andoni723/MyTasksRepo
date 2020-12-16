package com.example.everisdarmytasksms.Interface;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.everisdarmytasksms.Entity.tasks;

@Repository
public interface TaskRepository extends CrudRepository<tasks,Integer>{}
