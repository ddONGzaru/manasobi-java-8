package io.manasob.ex.stream;

import org.junit.Test;

import java.util.OptionalInt;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-08.
 */
public class Sum_unique_values_of_numeric_streams {

    // IntStream
    @Test
    public void sum_unique_values_intstream() {

        IntStream stream1 = IntStream.of(1, 2, 3);
        IntStream stream2 = IntStream.of(1, 2, 3);

        int val = IntStream.concat(stream1, stream2)
                           .distinct()
                           .sum();

        assertEquals(6, val);

        // or
        IntStream stream3 = IntStream.of(1, 2, 3);
        IntStream stream4 = IntStream.of(1, 2, 3);

        OptionalInt sum2 = IntStream.concat(stream3, stream4)
                                    .distinct()
                                    .reduce((a, b) -> a + b);

        assertEquals(6, sum2.getAsInt());
    }
}
