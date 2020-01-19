package com.springcloud.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-ZUUL", fallback=HelloServiceHystrix.class)
public interface HelloService {
	
	@RequestMapping(value = "/api-a/hi", method = RequestMethod.GET)
	public String callApiA(@RequestParam(value = "name") String name);
	
	@RequestMapping(value = "/api-b/hi", method = RequestMethod.GET)
	public String callApiB(@RequestParam(value = "name") String name);

}
