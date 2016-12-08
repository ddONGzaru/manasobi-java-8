package io.manasob.ex.stream;

import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by tw.jang on 2016-12-08.
 */
public class Convert_stream_to_set {

    @Test
    public void stream_to_set() {

        Set<Integer> numbers = Stream.of(1, 2, 2)
                                     .collect(Collectors.toSet());

        assertTrue(numbers.size() == 2);
    }
}
