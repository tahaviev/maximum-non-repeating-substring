package com.github.tahaviev;

import java.util.NoSuchElementException;
import org.cactoos.Scalar;

public final class NoSuchElement<T> implements Scalar<T> {

    @Override
    public T value() {
        throw new NoSuchElementException();
    }

}
