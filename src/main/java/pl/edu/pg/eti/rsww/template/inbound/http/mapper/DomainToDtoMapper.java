package pl.edu.pg.eti.rsww.template.inbound.http.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pg.eti.rsww.template.inbound.http.dto.ExampleResponse;
import pl.edu.pg.eti.rsww.template.logic.example.domain.Example;

import java.util.List;

@Component
public class DomainToDtoMapper {

    public ExampleResponse mapGetExampleResponse(Example example) {
        return new ExampleResponse(example.getId(), example.getText());
    }

    public List<ExampleResponse> mapGetExamplesResponse(List<Example> examples) {
        return examples.stream()
                .map(this::mapGetExampleResponse)
                .toList();
    }
}
