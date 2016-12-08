package io.manasob.ex.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by tw.jang on 2016-12-08.
 */
@Slf4j
public class Convert_stream_to_array {

    // Stream to array of strings
    @Test
    public void stream_of_strings_to_array() {

        String[] stringArray = Stream.of("One", "Two", "Three").toArray(String[]::new);

        log.info(Arrays.toString(stringArray));

        assertTrue(stringArray.length == 3);
    }

    // Stream to array of ints
    @Test
    public void stream_of_strings_to_ints_array() {

        Integer[] integers = Stream.of(1, 2, 3).toArray(Integer[]::new);

        log.info(Arrays.toString(integers));

        assertTrue(integers.length == 3);
    }

    // IntStream to array of ints
    @Test
    public void int_stream_to_array() {

        int[] intArray = IntStream.of(1, 2, 3).toArray();

        log.info(Arrays.toString(intArray));

        assertTrue(intArray.length == 3);
    }

    // LongStream to array of longs
    @Test
    public void long_stream_to_array() {

        long[] longArray = LongStream.of(10L, 20L, 30L).toArray();

        log.info(Arrays.toString(longArray));

        assertTrue(longArray.length == 3);
    }

    // Stream_double array of doubles
    @Test
    public void double_stream_to_array() {

        double[] doubleArray = DoubleStream.of(1.0, 2.0, 3.0).toArray();

        log.info(Arrays.toString(doubleArray));

        assertTrue(doubleArray.length == 3);
    }

}
