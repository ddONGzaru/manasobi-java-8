package io.manasob.ex.stream;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-08.
 */
public class Stream_intermediate_operations {

    // filter
    @Test
    public void intermediate_filter() {

        long elementsLessThanThree = Stream.of(1, 2, 3, 4)
                                           .filter(p -> p.intValue() < 3)
                                           .count();

        assertEquals(2, elementsLessThanThree);
    }

    // map
    @Test
    public void intermediate_map() {

        List<String> strings = Stream.of("one", null, "three")
                                     .map(s -> (s == null) ? "[unknown]" : s)
                                     .collect(toList());

        assertThat(strings).contains("one", "[unknown]", "three");
    }

    // flatmap
    @Test
    @Ignore
    public void count_distinct_words_java8() throws IOException {

        //File file = new File(sourceFileURI);
        File file = new File("");

        long uniqueWords = java.nio.file.Files.lines(Paths.get(file.toURI()), Charset.defaultCharset())
                                              .flatMap(line -> Arrays.stream(line.split(" .")))
                                              .distinct()
                                              .count();

        assertEquals(80, uniqueWords);
    }

    // peek :: The Stream.peek is extremely useful during debugging.
    @Test
    public void intermediate_peek() {

        List<String> strings = Stream.of("Badgers", "finals", "four")
                                     .filter(s -> s.length() >= 4)
                                     .peek(s -> System.out.println(s))
                                     .map(s -> s.toUpperCase())
                                     .collect(Collectors.toList());

        assertThat(strings).contains("BADGERS", "FINALS", "FOUR");
    }

    // distinct
    @Test
    public void intermediate_distinct() {

        List<Integer> distinctIntegers = IntStream.of(5, 6, 6, 6, 3, 2, 2)
                                                  .distinct()
                                                  .boxed()
                                                  .collect(Collectors.toList());

        assertEquals(4, distinctIntegers.size());
        assertThat(distinctIntegers).contains(5, 6, 3, 2);
    }

    // sorted
    @Test
    public void intermediate_sorted() {

        List<Integer> sortedNumbers = Stream.of(5, 3, 1, 3, 6)
                                            .sorted()
                                            .collect(Collectors.toList());

        assertThat(sortedNumbers).contains(1, 3, 3, 5, 6);

        List<Integer> reverseSortedNumbers = Stream.of(5, 3, 1, 3, 6)
                                            .sorted(Collections.reverseOrder())
                                            .collect(Collectors.toList());

        assertThat(reverseSortedNumbers).contains(6, 5, 3, 3, 1);
    }

    // limit
    @Test
    public void intermediate_limit() {

        List<String> vals = Stream.of("limit", "by", "two")
                                  .limit(2)
                                  .collect(Collectors.toList());

        assertThat(vals).contains("limit", "by");
    }
}
