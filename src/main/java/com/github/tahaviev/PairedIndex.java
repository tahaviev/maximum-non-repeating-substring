package com.github.tahaviev;

import java.util.Comparator;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import org.cactoos.Func;
import org.cactoos.Scalar;
import org.cactoos.text.TextEnvelope;

public interface PairedIndex {

    int x();

    int y();

    final class AsSubstringFor extends TextEnvelope {

        public AsSubstringFor(
            final String input, final Scalar<PairedIndex> pair
        ) {
            super(
                (Scalar<String>) () -> {
                    final PairedIndex value = pair.value();
                    return input.substring(value.x(), value.y() + 1);
                }
            );
        }

    }

    final class ComparingLength implements Comparator<PairedIndex> {

        @Delegate
        private final Comparator<PairedIndex> delegate
            = Comparator.comparingInt(pair -> pair.y() - pair.x()
        );

    }

    @RequiredArgsConstructor
    final class Of implements PairedIndex {

        private final int x;
        private final int y;

        @Override
        public int x() {
            return this.x;
        }

        @Override
        public int y() {
            return this.y;
        }

    }

    @RequiredArgsConstructor
    final class ToStringAsSubstring implements Func<PairedIndex, String> {

        private final String input;

        @Override
        public String apply(final PairedIndex input) {
            return this.input.substring(input.x(), input.y());
        }

    }

    final class XLessThanOrEqualsY implements Func<PairedIndex, Boolean> {

        @Override
        public Boolean apply(final PairedIndex input) {
            return input.x() <= input.y();
        }

    }

}
