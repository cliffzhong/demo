package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;





//This is for development using inbuilt tomcat
@SpringBootApplication
@ServletComponentScan
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		logger.trace("======= DemoApplication, this is a trace level logger info from {}", "Cliff");
		logger.debug("======= DemoApplication, this is a debug level logger info from {}", "Cliff");
		logger.info("======= DemoApplication, this is a info level logger info from {}", "Cliff");
		logger.warn("======= DemoApplication, this is a warn level logger info from {}", "Cliff");
		logger.error("======= DemoApplication, this is a error level logger info from {}", "Cliff");

	}

}


///*
////This is for development NOT using inbuilt tomcat
//*/
//@SpringBootApplication
//@ServletComponentScan
//public class DemoApplication extends SpringBootServletInitializer {
//
//	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class.getName());
//
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//
//		logger.trace("======= DemoApplication, this is a trace level logger info from {}", "Cliff");
//		logger.debug("======= DemoApplication, this is a debug level logger info from {}", "Cliff");
//		logger.info("======= DemoApplication, this is a info level logger info from {}", "Cliff");
//		logger.warn("======= DemoApplication, this is a warn level logger info from {}", "Cliff");
//		logger.error("======= DemoApplication, this is a error level logger info from {}", "Cliff");
//
//	}
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
//		return builder.sources(DemoApplication.class);
//	}
//
//}