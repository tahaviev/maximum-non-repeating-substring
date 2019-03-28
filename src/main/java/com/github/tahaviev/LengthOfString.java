package com.github.tahaviev;

import lombok.RequiredArgsConstructor;
import org.cactoos.Scalar;

@RequiredArgsConstructor
public final class LengthOfString implements Scalar<Integer> {

    private final String input;

    @Override
    public Integer value() {
        return this.input.length();
    }

}
