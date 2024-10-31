package com.prueba.cliente.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Bean
	public Queue movimientoQueue() {
		return new Queue("movimientoQueue", true);
	}

	@Bean
	public Jackson2JsonMessageConverter consumerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

}
