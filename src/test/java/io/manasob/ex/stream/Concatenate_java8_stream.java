package io.manasob.ex.stream;

import org.junit.Test;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by tw.jang on 2016-12-08.
 */
public class Concatenate_java8_stream {

    // Join Stream of Strings
    @Test
    public void join_stream() {

        Stream<String> stream1 = Stream.of("one", "two");
        Stream<String> stream2 = Stream.of("three", "four");

        Stream.concat(stream1, stream2).forEach(e -> System.out.println(e));
    }

    // Join IntStream
    @Test
    public void join_intstream() {

        IntStream intStream1 = IntStream.of(1, 2);
        IntStream intStream2 = IntStream.of(3, 4);

        IntStream.concat(intStream1, intStream2).forEach(System.out::println);
    }

    // Join LongStream
    @Test
    public void join_longstreamstream() {

        LongStream longStream1 = LongStream.of(5, 6);
        LongStream longStream2 = LongStream.of(7, 8);

        LongStream.concat(longStream1, longStream2).forEach(System.out::println);
    }

    // Join Stream_double
    @Test
    public void join_doublestream_stream() {

        DoubleStream doubleStream1 = DoubleStream.of(9, 10);
        DoubleStream doubleStream2 = DoubleStream.of(11, 12);

        DoubleStream.concat(doubleStream1, doubleStream2).forEach(
                e -> System.out.println(e));

    }
}
