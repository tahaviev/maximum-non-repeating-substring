package com.github.tahaviev;

import java.util.Comparator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class ReversedComparator<T> implements Comparator<T> {

    private final Comparator<T> origin;

    @Override
    public int compare(final T first, final T second) {
        return this.origin.compare(second, first);
    }

}
