package com.yash_project.springboot.springbootwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("say-hello")
	public String sayHello() {
		return "sayHello";
	}
}
