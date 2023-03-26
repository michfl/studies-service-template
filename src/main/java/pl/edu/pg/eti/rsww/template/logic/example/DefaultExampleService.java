package pl.edu.pg.eti.rsww.template.logic.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.edu.pg.eti.rsww.template.logic.example.domain.Example;
import pl.edu.pg.eti.rsww.template.logic.example.exception.TextToLongException;
import pl.edu.pg.eti.rsww.template.outbound.jpa.ExampleRepository;
import pl.edu.pg.eti.rsww.template.outbound.jpa.entity.ExampleEntity;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class DefaultExampleService implements ExampleService {

    private final ExampleRepository exampleRepository;

    public DefaultExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    @Override
    public void create(Example example) {
        validate(example);
        var exampleEntity = ExampleEntity.builder()
                .text(example.text())
                .build();
        exampleRepository.save(exampleEntity);
    }

    @Override
    public Optional<Example> get(long id) {
        var exampleEntity = exampleRepository.findById(id);
        if (exampleEntity.isPresent()) {
            var entity = exampleEntity.get();
            return Optional.of(new Example(entity.getId(), entity.getText()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Example> getAll() {
        return exampleRepository.findAll().stream()
                .map(entity -> new Example(entity.getId(), entity.getText()))
                .toList();
    }

    private void validate(Example example) {
        if (example.text().length() > 100) {
            throw new TextToLongException();
        }
    }
}
