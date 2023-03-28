package pl.edu.pg.eti.rsww.template.logic.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edu.pg.eti.rsww.template.logic.example.domain.Example;
import pl.edu.pg.eti.rsww.template.logic.example.exception.TextToLongException;
import pl.edu.pg.eti.rsww.template.outbound.jpa.ExampleRepository;

@ExtendWith(MockitoExtension.class)
public class DefaultExampleServiceTest {

    @Mock
    private ExampleRepository exampleRepository;

    @InjectMocks
    private DefaultExampleService service;

    @Test
    void create_textToLong_throw() {
        // given
        var example = Example.builder()
                .text("x".repeat(101))
                .build();

        // when & then
        Assertions.assertThrows(
                TextToLongException.class,
                () -> service.create(example));
    }
}
