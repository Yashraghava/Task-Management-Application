package com.yash_project.springboot.springbootwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TaskControllerJpa {
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	TaskRepository taskRepository;

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String userName = (String) this.getLoggedInUserName();
		List<Task> tasks = taskRepository.findByUsername(userName);
		model.put("tasks", tasks);
		return "listTasks";
	}

	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String userName = (String) this.getLoggedInUserName();
		Task task = new Task(0,userName,"Default Desc",LocalDate.now().plusYears(1), false); 
		model.put("task",task);
		return "task";
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Task task, BindingResult result) {
		if(result.hasErrors()) {
			return "task";
		}
		String userName = (String) this.getLoggedInUserName();
		task.setUsername(userName);
		taskRepository.save(task);
//		todoService.addTodo(userName, todo.getDescription(), LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("youtube")
	public RedirectView gotoYoutube() {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://www.youtube.com");
		return redirectView;
	}

	@RequestMapping(value="delete-todo",method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		taskRepository.deleteById(id);
//		todoService.deleteTodo(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showUpdateTodo(ModelMap model,@RequestParam int id) {
		Task task = taskRepository.findById(id).get();
		model.put("task", task);
		return "task";
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Task task, BindingResult result) {
		if(result.hasErrors()) {
			return "task";
		}
		String userName = (String) this.getLoggedInUserName();
		taskRepository.deleteById(task.getId());
		task.setUsername(userName);
		taskRepository.save(task);
//		LocalDate date = todo.getDate();
//		todo.setDate(date);
//		todo.setUsername(userName);
//		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}

	public String getLoggedInUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}
