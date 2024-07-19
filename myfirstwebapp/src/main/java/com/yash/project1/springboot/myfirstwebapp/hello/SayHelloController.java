package com.yash.project1.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class SayHelloController {
// Say-hello -> "hello yash"
	
	@RequestMapping("say-hello-jsp")
	//@ResponseBody
	public String sayHelloJsp() {

		return "sayHello";
	}
}
