package com.parque.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.parque.facade.Facade;



@Configuration
@ComponentScan(basePackageClasses = Facade.class)
public class FacadeConfig {

}