package com.parque.config.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.parque.config.WebConfig;
import com.parque.facade.Facade;
import com.parque.service.AssociacaoCartaoService;
import com.parque.service.ClienteService;
import com.parque.service.ContaService;
import com.parque.service.RecargaService;

public class AppInitialize extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] 
				{
					WebConfig.class,
					Facade.class,
					ContaService.class,
					ClienteService.class,
					AssociacaoCartaoService.class,
					RecargaService.class
				};
	}
	

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}
	
	

}
