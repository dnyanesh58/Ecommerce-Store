package com.epstore;

import org.modelmapper.ModelMapper;

import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class EPlumbingStoreApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(EPlumbingStoreApplication.class, args);
	}

	@Bean // equivalent to <bean id ..../> in xml file
	public ModelMapper configureMapper() {
		System.out.println("in config mapper....");
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;//method rets bean instance to SC
	}
}
