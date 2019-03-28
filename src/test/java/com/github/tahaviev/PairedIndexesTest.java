package com.github.tahaviev;

import org.cactoos.list.Mapped;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public final class PairedIndexesTest {

    @Test
    public void size() {
        MatcherAssert.assertThat(
            new PairedIndexes(4, 3),
            Matchers.iterableWithSize(12)
        );
    }

    @Test
    public void content() {
        MatcherAssert.assertThat(
            new Mapped<>(
                pair -> 10 * pair.x() + pair.y(),
                new PairedIndexes(4, 3)
            ),
            Matchers.contains(
                0, 1, 2, 10, 11, 12, 20, 21, 22, 30, 31, 32
            )
        );
    }

}
