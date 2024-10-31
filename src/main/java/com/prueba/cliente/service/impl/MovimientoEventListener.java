package com.prueba.cliente.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.prueba.cliente.config.MovimientoRegistradoEvent;

@Service
public class MovimientoEventListener {

	private static final Logger logger = LoggerFactory.getLogger(MovimientoEventListener.class);

	@RabbitListener(queues = "movimientoQueue")
	public void recibirMovimientoRegistradoEvento(Message<MovimientoRegistradoEvent> evento) {
		final var eventString = evento.getPayload().toString();
		logger.info("Movimiento recibido en el microservicio Cliente: {}", eventString);
	}
}
