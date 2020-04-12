package com.lifei.rpncalculator;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.annotation.Resource;

@SpringBootApplication
public class RpncalculatorApplication implements ApplicationRunner {
	@Resource
	private RPNCalcEngine rpnCalcEngine;

	public static void main(String[] args) {
//		SpringApplication.run(RpncalculatorApplication.class, args);
		new SpringApplicationBuilder(RpncalculatorApplication.class)
				.web(WebApplicationType.NONE) // .REACTIVE, .SERVLET
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		rpnCalcEngine.calc();
	}
}
