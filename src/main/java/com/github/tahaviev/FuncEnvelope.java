package com.github.tahaviev;

import lombok.RequiredArgsConstructor;
import org.cactoos.Func;
import org.cactoos.Scalar;

@RequiredArgsConstructor
public abstract class FuncEnvelope<X, Y> implements Func<X, Y> {

    private final Scalar<Func<X, Y>> origin;

    @Override
    public final Y apply(final X input) throws Exception {
        return this.origin.value().apply(input);
    }

}
