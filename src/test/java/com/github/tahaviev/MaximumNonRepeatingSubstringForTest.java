package com.github.tahaviev;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public final class MaximumNonRepeatingSubstringForTest {

    @ParameterizedTest
    @CsvSource(
        {
            "abcabcabc, abc",
            "aaaa, a",
            "abcddcba, abcd",
            "aabcc, abc",
            "abababcabcd, abcd"
        }
    )
    public void logic(
        final String input, final String maximum
    ) throws Exception {
        MatcherAssert.assertThat(
            new MaximumNonRepeatingSubstringFor(input).asString(),
            Matchers.equalTo(maximum)
        );
    }

}
