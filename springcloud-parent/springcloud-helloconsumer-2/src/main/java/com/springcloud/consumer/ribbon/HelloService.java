package com.springcloud.consumer.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

	@Autowired
	private RestTemplate restTemplate;
	
	public String callHiService(String name) {
		return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name , String.class);
	}
	
}
