package pl.edu.pg.eti.rsww.template.logic.example.exception;

import pl.edu.pg.eti.rsww.template.logic.exception.ValidationException;

public class TextToLongException extends ValidationException {

    public TextToLongException() {
        super("Example text is to long, max allowed is 100.");
    }
}
