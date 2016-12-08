package io.manasob.ex.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by tw.jang on 2016-12-08.
 */
@Slf4j
public class Numeric_ranges {

    // Range
    @Test
    public void instream_range() {

        Set<Integer> range = IntStream.range(1, 10)
                                      .boxed()
                                      .collect(Collectors.toSet());

        log.info(range.toString());
    }

    // RangeClosed
    @Test
    public void instream_range_closed() {

        Set<Integer> range = IntStream.rangeClosed(1, 10)
                                      .boxed()
                                      .collect(Collectors.toSet());

        log.info(range.toString());
    }

}
