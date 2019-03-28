package com.github.tahaviev;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import org.cactoos.Func;
import org.cactoos.func.FuncOf;
import org.cactoos.scalar.StickyScalar;

public final class ConditionForPairedIndexedExcludedFrom
    extends FuncEnvelope<PairedIndex, Boolean> {

    public ConditionForPairedIndexedExcludedFrom(
        final Collection<? extends List<Integer>> occurrences
    ) {
        super(
            new StickyScalar<>(
                () -> occurrences
                    .stream()
                    .flatMap(
                        positions -> IntStream
                            .range(0, positions.size() - 1)
                            .boxed()
                            .<Func<PairedIndex, Boolean>>map(
                                index ->
                                    pair -> pair.x() > positions.get(index)
                                        || pair.y() < positions.get(index + 1)
                            )
                    )
                    .reduce(
                        (first, second) ->
                            input -> first.apply(input) && second.apply(input)
                    )
                    .orElseGet(() -> new FuncOf<>(true))
            )
        );
    }

}
