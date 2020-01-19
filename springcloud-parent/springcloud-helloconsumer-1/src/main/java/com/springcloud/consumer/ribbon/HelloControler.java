package com.springcloud.consumer.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
	
	@Autowired
	private HelloService helloService;
	
	@RequestMapping("/hi")
	public String callHiServcie(@RequestParam String name) {
		return helloService.callHiService(name);
	}

}
