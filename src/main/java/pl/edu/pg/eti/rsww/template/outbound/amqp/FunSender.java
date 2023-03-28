package pl.edu.pg.eti.rsww.template.outbound.amqp;

import pl.edu.pg.eti.rsww.template.inbound.amqp.messages.FunMessage;

public interface FunSender {

    void sendFun(FunMessage message);
}
