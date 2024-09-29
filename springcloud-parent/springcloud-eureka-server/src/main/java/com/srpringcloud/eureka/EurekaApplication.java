package com.srpringcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	public static void test_1(){
		int a = 10;
		int b = 0;
		int c = a / b;
		System.out.println(c);
	}

	public static void test_2(){
		int a = 10;
		int b = 0;
		int c = a / b;
		System.out.println(c);
	}

	public static void test_3(){
		int a = 10;
		int b = 0;
		int c = a / b;
		System.out.println(c);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
		//new SpringApplicationBuilder(EurekaApplication.class).run(args);
	}

}
