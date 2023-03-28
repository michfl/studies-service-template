package pl.edu.pg.eti.rsww.template.logic.fun.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Builder
public final class Fun {

    private final String fun;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Fun) obj;
        return Objects.equals(this.fun, that.fun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fun);
    }

    @Override
    public String toString() {
        return "Fun[" +
                "fun=" + fun + ']';
    }

}
