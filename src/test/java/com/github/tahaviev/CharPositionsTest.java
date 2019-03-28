package com.github.tahaviev;

import org.cactoos.list.ListOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public final class CharPositionsTest {

    @Test
    public void logic() {
        MatcherAssert.assertThat(
            new CharPositions("abccbac"),
            Matchers.contains(
                new ListOf<>(0, 5),
                new ListOf<>(1, 4),
                new ListOf<>(2, 3, 6)
            )
        );
    }

}
