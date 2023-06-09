package pl.edu.pg.eti.rsww.template.logic.example.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Builder
public final class Example {

    private long id;
    private String text;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Example) obj;
        return this.id == that.id &&
                Objects.equals(this.text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }

    @Override
    public String toString() {
        return "Example[" +
                "id=" + id + ", " +
                "text=" + text + ']';
    }

}
