package io.manasob.ex.stream;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by tw.jang on 2016-12-08.
 */
public class Stream_terminal_operations {

    // forEach
    @Test
    public void terminal_operation_foreach () {

        Stream.of("Hello", "World").forEach(p -> System.out.println(p));
    }

    // toArray
    @Test
    public void terminal_operation_toArray() {

        Object[] objects = Stream.of(1, 2).toArray();

        assertTrue(objects.length == 2);
    }

    // reduce
    @Test
    public void terminal_operation_reduce() {

        int sum = IntStream.of(1, 2, 3, 4)
                           .reduce(0, (a, b) -> a + b);

        assertEquals(10, sum);

        assertEquals(10, IntStream.of(1, 2, 3, 4).sum());
    }

    // collect
    @Test
    public void terminal_operation_collect() {

        Set<String> stringSet = Stream.of("some", "one", "some", "one")
                                      .collect(Collectors.toSet());

        assertThat(stringSet).contains("some", "one");

        assertTrue(stringSet.size() == 2);
    }

    // min
    @Test
    public void terminal_operation_min() {

        OptionalInt minimum = IntStream.of(1, 2, 3).min();

        assertEquals(1,  minimum.getAsInt());
    }

    // max
    @Test
    public void terminal_operation_max() {

        OptionalDouble max = Stream.of(1d, 2d, 3d)
                                   .mapToDouble(Double::doubleValue)
                                   .max();

        assertEquals(1, max.getAsDouble(), 0);
    }

    // count
    @Test
    public void terminal_operation_count() {

        long count = Stream.of("one").count();

        assertEquals(1, count);
    }

    // anymatch
    @Test
    public void terminal_operation_anymatch() {

        boolean lengthOver5 = Stream.of("two", "three", "eighteen")
                                    .anyMatch(s -> s.length() > 5);

        assertTrue(lengthOver5);
    }

    // allMatch
    @Test
    public void terminal_operation_allmatch() {

        List<String> cookies = Lists.newArrayList("Peanut Butter Cookies", "Oatmeal-Raisin Cookies", "Basic Chocolate Chip Cookies");

        boolean containCookies = cookies.stream()
                                        .allMatch(p -> p.contains("Cookies"));

        assertTrue(containCookies);
    }

    // noneMatch
    @Test
    public void terminal_operation_nonematch() {

        boolean noElementEqualTo5 = IntStream.of(1, 2, 3)
                                             .noneMatch(p -> p == 5);

        assertTrue(noElementEqualTo5);
    }

    // findFirst
    @Test
    public void terminal_operation_findfirst() {

        Optional<String> val = Stream.of("one", "two").findFirst();

        assertEquals("one", val);
    }

    // findAny
    @Test
    public void terminal_operation_findany() {

        Optional<String> val = Stream.of("one", "two").findAny();

        assertEquals("one", val.get());
    }


}
