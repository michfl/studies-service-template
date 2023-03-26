package pl.edu.pg.eti.rsww.template.logic.example.domain;

public record Example(long id, String text) {

    public Example(String text) {
        this(0, text);
    }
}
