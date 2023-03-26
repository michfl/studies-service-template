package pl.edu.pg.eti.rsww.template.logic.example;

import pl.edu.pg.eti.rsww.template.logic.example.domain.Example;

import java.util.List;
import java.util.Optional;

public interface ExampleService {

    void create(Example example);

    Optional<Example> get(long id);

    List<Example> getAll();
}
