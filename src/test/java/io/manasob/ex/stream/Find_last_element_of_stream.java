package io.manasob.ex.stream;

import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-08.
 */
public class Find_last_element_of_stream {

    // Stream Reduce
    @Test
    public void last_element_stream() {

        Optional<String> optionalJava = Stream.of("a", "b", "c")
                                              .reduce((a, b) -> b);

        assertEquals("c", optionalJava.get());

        String lastValue = Stream.of("a", "b", "c").reduce((a, b) -> b)
                                                   .orElse("false");

        assertEquals("c", lastValue);
    }
}
