package pl.edu.pg.eti.rsww.template.inbound.http;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.edu.pg.eti.rsww.template.inbound.http.dto.SendFunRequest;
import pl.edu.pg.eti.rsww.template.inbound.http.mapper.DtoToDomainMapper;
import pl.edu.pg.eti.rsww.template.logic.fun.FunService;

@ApiController
public class FunApi {

    public static final String FUN_PATH = "fun";

    private final FunService funService;
    private final DtoToDomainMapper dtoToDomainMapper;

    public FunApi(FunService funService, DtoToDomainMapper dtoToDomainMapper) {
        this.funService = funService;
        this.dtoToDomainMapper = dtoToDomainMapper;
    }

    @PostMapping(path = FUN_PATH)
    public ResponseEntity<Void> postFun(@RequestBody SendFunRequest request) {
        funService.sendFun(dtoToDomainMapper.mapSendFunRequest(request));
        return ResponseEntity.ok().build();
    }
}
