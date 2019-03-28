package com.github.tahaviev;

import java.util.Iterator;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.cactoos.Scalar;
import org.cactoos.scalar.Constant;
import org.cactoos.scalar.UncheckedScalar;

@RequiredArgsConstructor
public final class PairedIndexes implements Iterable<PairedIndex> {

    private final Scalar<Integer> length;

    private final Scalar<Integer> height;

    public PairedIndexes(final Integer length, final Integer height) {
        this(new Constant<>(length), new Constant<>(height));
    }

    public PairedIndexes(final Scalar<Integer> length) {
        this(length, length);
    }

    @Override
    public Iterator<PairedIndex> iterator() {
        return IntStream
            .range(0, new UncheckedScalar<>(this.length).value())
            .boxed()
            .<PairedIndex>flatMap(
                x -> IntStream
                    .range(0, new UncheckedScalar<>(this.height).value())
                    .boxed()
                    .map(y -> new PairedIndex.Of(x, y))
            )
            .iterator();
    }

}
