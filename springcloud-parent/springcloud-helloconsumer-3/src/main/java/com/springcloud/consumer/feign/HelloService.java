package com.springcloud.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-HI", fallback=HelloServiceHystrix.class)
public interface HelloService {
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String callHiService(@RequestParam(value = "name") String name);

}
