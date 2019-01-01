package com.example.demoheader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DemoHeaderApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoHeaderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("test");
					
		
		List<String> s =  Arrays.asList("a","b","c");
		
		List<String> a = s.stream().map( v -> v.toUpperCase()).collect(Collectors.toList());
		
		
		
	}
	

}

