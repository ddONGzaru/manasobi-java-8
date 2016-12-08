package io.manasob.ex.stream;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by tw.jang on 2016-12-08.
 */
public class Build_a_stream {

    // Stream from values
    @Test
    public void stream_from_values() {

        Stream<String> stream = Stream.of(
            "java 8 ", "leveluplunch.com", "examples", "exercises"
        );

        String joined = stream.map(String::trim)
                              .collect(joining(","));

        assertEquals("java 8,leveluplunch.com,examples,exercises", joined);
    }

    // Empty stream
    @Test
    public void empty_stream() {

        Stream<String> emptyStream = Stream.empty();

        long val = emptyStream.count();

        assertTrue(val == 0);
    }

    // Stream from array
    @Test
    public void stream_from_array() {

        int[] numbers = { 1, 2, 3, 4, 5, 6, 7 };

        int sum = Arrays.stream(numbers).sum();

        assertEquals(28, sum);

        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5);

        sum = numberList.stream().mapToInt(Integer::valueOf).sum();

        assertEquals(15, sum);
    }

    // Stream from file
    @Test
    @Ignore
    public void stream_from_file() throws IOException {

        long uniqueWords = java.nio.file.Files
                .lines(Paths.get("word-occurrences-in-file.txt"),
                        Charset.defaultCharset())
                .flatMap(line -> Arrays.stream(line.split(" ."))).distinct()
                .count();

        assertEquals(80, uniqueWords);
    }

    // Stream from function
    @Test
    public void stream_from_function() {

        Stream.iterate(0, n -> n + 3).limit(10).forEach(System.out::println);
    }

    // Stream from generate
    @Test
    public void stream_from_random() {

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
