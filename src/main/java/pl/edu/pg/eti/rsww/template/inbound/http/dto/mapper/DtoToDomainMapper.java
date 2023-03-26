package pl.edu.pg.eti.rsww.template.inbound.http.dto.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.rsww.template.inbound.http.dto.PutExampleRequest;
import pl.edu.pg.eti.rsww.template.logic.example.domain.Example;

@Component
public class DtoToDomainMapper {

    public Example mapPutExampleRequest(PutExampleRequest request) {
        return new Example(request.text());
    }
}
