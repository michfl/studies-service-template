package pl.edu.pg.eti.rsww.template.inbound.amqp.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.rsww.template.inbound.amqp.messages.FunMessage;

import static pl.edu.pg.eti.rsww.template.configuration.RabbitMqConfiguration.FUN_QUEUE;

@Slf4j
@Service
public class RabbitMqFunReceiver {

    @RabbitListener(queues = {FUN_QUEUE})
    public void onFunMessage(FunMessage event) {
        log.info("Fun received: {}", event);
    }
}
