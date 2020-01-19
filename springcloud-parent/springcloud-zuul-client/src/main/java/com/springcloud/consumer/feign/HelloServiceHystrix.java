package com.springcloud.consumer.feign;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystrix implements HelloService {

	@Override
	public String callApiA(String name) {
		 return "hi "+name+", call zuul Api A occur error!";
	}
	
	@Override
	public String callApiB(String name) {
		 return "hi "+name+", call zuul Api B occur error!";
	}

}
