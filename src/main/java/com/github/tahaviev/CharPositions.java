package com.github.tahaviev;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.cactoos.collection.CollectionEnvelope;

public final class CharPositions extends CollectionEnvelope<List<Integer>> {

    public CharPositions(final String input) {
        super(
            () -> IntStream
                .range(0, input.length())
                .boxed()
                .collect(Collectors.groupingBy(input::charAt))
                .values()
        );
    }

}
