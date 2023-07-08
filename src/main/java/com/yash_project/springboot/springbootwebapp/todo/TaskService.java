package com.yash_project.springboot.springbootwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TaskService {
	private static List<Task> tasks = new ArrayList();
	private static int tasksCount=0;
	static {
		tasks.add(new Task(++tasksCount,"in28minutes","Learn AWS Certified! 1",LocalDate.now().plusYears(1),false));
		tasks.add(new Task(++tasksCount,"in28minutes","Learn Devops 1",LocalDate.now().plusYears(1),false));
		tasks.add(new Task(++tasksCount,"in28minutes","Learn Full Stack Development 1",LocalDate.now().plusYears(1),false));
	}
	
	public List<Task> findByUsername(String username){
		Predicate<? super Task> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		List<Task> todoList = tasks.stream().filter(predicate).collect(Collectors.toList());
		return todoList;
	}
	
	public void addTodo(String name,String description,LocalDate date,boolean done) {
		tasks.add(new Task(++tasksCount,name,description,date,done));
	}
	public void deleteTodo(int id) {
		Predicate<? super Task> predicate = todo -> todo.getId() == id;
		tasks.removeIf(predicate);
	}

	public Task findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Task> predicate = task -> task.getId() == id;
		Task task = tasks.stream().filter(predicate).findFirst().get();
		return task;
	}

	public void updateTodo(@Valid Task task) {
		// TODO Auto-generated method stub
		this.deleteTodo(task.getId());
		tasks.add(task);
	}

	
}
