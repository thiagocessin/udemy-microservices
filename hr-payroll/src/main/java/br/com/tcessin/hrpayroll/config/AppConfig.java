package br.com.tcessin.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	
	//regista uma instancia única (singleton) de um obj e fica disponível para ser injetado
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
