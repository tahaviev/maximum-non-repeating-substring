package com.github.tahaviev;

import org.cactoos.list.ListOf;
import org.cactoos.scalar.And;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public final class ConditionForPairedIndexedExcludedFromTest {

    @ParameterizedTest
    @CsvSource({"2,4", "4,8", "1,4", "2,5"})
    public void accept(final int x, final int y) throws Exception {
        MatcherAssert.assertThat(
            new And(
                new ConditionForPairedIndexedExcludedFrom(
                    new ListOf<>(
                        new ListOf<>(1, 5),
                        new ListOf<>(3, 6, 9)
                    )
                ),
                new PairedIndex.Of(x, y)
            ).value(),
            Matchers.is(true)
        );
    }

    @ParameterizedTest
    @CsvSource({"2,7", "2,6", "3,7", "3,6"})
    public void negate(final int x, final int y) throws Exception {
        MatcherAssert.assertThat(
            new And(
                new ConditionForPairedIndexedExcludedFrom(
                    new ListOf<>(
                        new ListOf<>(1, 5),
                        new ListOf<>(3, 6, 9)
                    )
                ),
                new PairedIndex.Of(x, y)
            ).value(),
            Matchers.is(false)
        );
    }

}
