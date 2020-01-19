package com.springcloud.consumer.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
	
	@Autowired
	private HelloService helloService;
	
	@RequestMapping("/api-a/hi")
	public String callApiA(@RequestParam String name) {
		System.out.println("call into zuul client");
		return helloService.callApiA(name);
	}
	
	@RequestMapping("/api-b/hi")
	public String callApiB(@RequestParam String name) {
		System.out.println("call into zuul client");
		return helloService.callApiA(name);
	}

}
