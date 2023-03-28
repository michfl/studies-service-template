package pl.edu.pg.eti.rsww.template.outbound.amqp.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.rsww.template.inbound.amqp.messages.FunMessage;
import pl.edu.pg.eti.rsww.template.outbound.amqp.FunSender;

@Slf4j
@Service
public class RabbitMqFunSender implements FunSender {

    public static final String FUN_EXCHANGE = "";
    public static final String FUN_ROUTING_KEY = "q.fun-queue";

    private final RabbitTemplate rabbitTemplate;

    public RabbitMqFunSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendFun(FunMessage message) {
        log.info("Sending {} to exchange: '{}' with routingKey: '{}'", message, FUN_EXCHANGE, FUN_ROUTING_KEY);
        rabbitTemplate.convertAndSend(FUN_EXCHANGE, FUN_ROUTING_KEY, message);
    }
}
