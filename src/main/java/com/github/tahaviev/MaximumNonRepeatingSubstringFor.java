package com.github.tahaviev;

import org.cactoos.iterable.Filtered;
import org.cactoos.iterable.Sorted;
import org.cactoos.scalar.FirstOf;
import org.cactoos.text.TextEnvelope;

public final class MaximumNonRepeatingSubstringFor extends TextEnvelope {

    public MaximumNonRepeatingSubstringFor(final String input) {
        super(
            new PairedIndex.AsSubstringFor(
                input,
                new FirstOf<>(
                    new ConditionForPairedIndexedExcludedFrom(
                        new CharPositions(input)
                    ),
                    new Sorted<>(
                        new ReversedComparator<>(
                            new PairedIndex.ComparingLength()
                        ),
                        new Filtered<>(
                            new PairedIndex.XLessThanOrEqualsY(),
                            new PairedIndexes(
                                new LengthOfString(input)
                            )
                        )
                    ),
                    new NoSuchElement<>()
                )
            )
        );
    }

}
