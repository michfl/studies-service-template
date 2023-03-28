package pl.edu.pg.eti.rsww.template.inbound.http;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.edu.pg.eti.rsww.template.inbound.http.dto.ExampleResponse;
import pl.edu.pg.eti.rsww.template.inbound.http.dto.PutExampleRequest;
import pl.edu.pg.eti.rsww.template.inbound.http.mapper.DomainToDtoMapper;
import pl.edu.pg.eti.rsww.template.inbound.http.mapper.DtoToDomainMapper;
import pl.edu.pg.eti.rsww.template.logic.example.ExampleService;

import java.util.List;

@ApiController
public class ExampleApi {

    public static final String EXAMPLE_PATH = "example";

    private final ExampleService exampleService;
    private final DomainToDtoMapper domainToDtoMapper;
    private final DtoToDomainMapper dtoToDomainMapper;

    public ExampleApi(ExampleService exampleService,
                      DomainToDtoMapper domainToDtoMapper,
                      DtoToDomainMapper dtoToDomainMapper) {
        this.exampleService = exampleService;
        this.domainToDtoMapper = domainToDtoMapper;
        this.dtoToDomainMapper = dtoToDomainMapper;
    }

    @GetMapping(path = EXAMPLE_PATH)
    public ResponseEntity<List<ExampleResponse>> getExamples() {
        return ResponseEntity.ok(domainToDtoMapper.mapGetExamplesResponse(exampleService.getAll()));
    }

    @GetMapping(path = EXAMPLE_PATH + "/{id}")
    public ResponseEntity<ExampleResponse> getExample(@PathVariable long id) {
        var example = exampleService.get(id);
        return example.map(value -> ResponseEntity.ok(domainToDtoMapper.mapGetExampleResponse(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = EXAMPLE_PATH)
    public ResponseEntity<Void> putExample(@RequestBody PutExampleRequest request) {
        exampleService.create(dtoToDomainMapper.mapPutExampleRequest(request));
        return ResponseEntity.noContent().build();
    }
}
