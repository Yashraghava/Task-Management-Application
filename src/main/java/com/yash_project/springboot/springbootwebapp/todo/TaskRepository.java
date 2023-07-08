package com.yash_project.springboot.springbootwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer>{
	
	public List<Task> findByUsername(String username);

}
