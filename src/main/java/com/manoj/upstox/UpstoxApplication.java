package com.manoj.upstox;

import com.manoj.upstox.utils.ClientRequestInterceptor;
import com.manoj.upstox.utils.RequestResponseLoggingInterceptor;
import com.manoj.upstox.utils.RestTemplateRequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
@EnableSwagger2
public class UpstoxApplication extends WebMvcConfigurerAdapter {

	@Autowired
	private ClientRequestInterceptor clientRequestInterceptor;

	@Autowired
	private RequestResponseLoggingInterceptor requestResponseLoggingInterceptor;

	@Autowired
	private RestTemplateRequestInterceptor restTemplateRequestInterceptor;


	public static void main(String[] args) {
		SpringApplication.run(UpstoxApplication.class, args);


	}

	@Bean
	public RestTemplate getRestTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(requestResponseLoggingInterceptor);

		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(clientRequestInterceptor).addPathPatterns("/upstox/**");

	}
}
