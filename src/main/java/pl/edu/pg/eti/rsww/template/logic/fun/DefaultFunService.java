package pl.edu.pg.eti.rsww.template.logic.fun;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.rsww.template.inbound.amqp.messages.FunMessage;
import pl.edu.pg.eti.rsww.template.logic.fun.domain.Fun;
import pl.edu.pg.eti.rsww.template.outbound.amqp.FunSender;

@Service
@Primary
public class DefaultFunService implements FunService {

    private final FunSender sender;

    public DefaultFunService(FunSender sender) {
        this.sender = sender;
    }

    @Override
    public void sendFun(Fun fun) {
        var message = new FunMessage(fun.getFun());
        sender.sendFun(message);
    }
}
