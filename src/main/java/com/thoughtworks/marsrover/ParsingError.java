package com.thoughtworks.marsrover;

import java.util.Objects;

public class ParsingError {
    private final String reason;

    public ParsingError(final String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ParsingError that = (ParsingError) o;
        return reason.equals(that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reason);
    }
}
