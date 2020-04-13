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
		new SpringApplicationBuilder(RpncalculatorApplication.class)
				.web(WebApplicationType.NONE)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// avoid being blocked in unit test
		if(args.getSourceArgs().length > 0 && "test".equalsIgnoreCase(args.getSourceArgs()[0])) {
			return;
		}
		rpnCalcEngine.calc();
	}
}
