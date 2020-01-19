package com.springcloud.consumer.feign;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystrix implements HelloService {

	@Override
	public String callHiService(String name) {
		 return "hi "+name+", call hiService occur error!";
	}
	
	

}
