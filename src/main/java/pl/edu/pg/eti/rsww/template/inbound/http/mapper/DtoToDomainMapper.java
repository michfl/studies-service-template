package pl.edu.pg.eti.rsww.template.inbound.http.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.rsww.template.inbound.http.dto.PutExampleRequest;
import pl.edu.pg.eti.rsww.template.inbound.http.dto.SendFunRequest;
import pl.edu.pg.eti.rsww.template.logic.example.domain.Example;
import pl.edu.pg.eti.rsww.template.logic.fun.domain.Fun;

@Component
public class DtoToDomainMapper {

    public Example mapPutExampleRequest(PutExampleRequest request) {
        return Example.builder()
                .text(request.text())
                .build();
    }

    public Fun mapSendFunRequest(SendFunRequest request) {
        return Fun.builder()
                .fun(request.fun())
                .build();
    }
}
