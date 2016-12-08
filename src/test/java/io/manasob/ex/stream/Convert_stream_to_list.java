package io.manasob.ex.stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertTrue;

/**
 * Created by tw.jang on 2016-12-08.
 */
public class Convert_stream_to_list {

    @Test
    public void stream_to_list() {

        List<String> abc = Stream.of("a", "b", "c")
                                 .collect(toList());

        assertTrue(abc.size() == 3);
    }
}
