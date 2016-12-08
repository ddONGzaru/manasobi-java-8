package io.manasob.ex.stream;

import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by tw.jang on 2016-12-08.
 */
public class Convert_stream_to_string {

    @Test
    public void stream_to_string() {

        String streamToString = Stream.of("a", "b", "c")
                                      .collect(Collectors.joining());

        assertEquals("abc", streamToString);
    }
}
