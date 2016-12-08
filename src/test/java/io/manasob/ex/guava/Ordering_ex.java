package io.manasob.ex.guava;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.reverseOrder;
import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-08.
 */
@Slf4j
public class Ordering_ex {

    // Min value
    @Test
    public void order_list_of_strings_alphabetically_case_insensitive () {

        List<String> TOP_RATED_CENTERS = Lists.newArrayList(
                "Dawson", "Gatski",  "Langer",     "Hein",  "Frankie Baggadonuts",
                "Turner", "Trafton", "Stephenson", "Ringo", "Otto",
                "Webster");


        String topNameAlphabetically = Ordering.from(String.CASE_INSENSITIVE_ORDER)
                                               .min(TOP_RATED_CENTERS);

        assertEquals("Dawson", topNameAlphabetically);

        // Java 8 - Stream API
        Optional<String> result = TOP_RATED_CENTERS.stream()
                                                   .sorted(String.CASE_INSENSITIVE_ORDER)
                                                   .findFirst();

        assertEquals("Dawson", result.get());
    }

    // Max value
    @Test
    public void find_max_value_from_list_of_integers_guava () {

        List<Integer> top10CentersNumbers = Lists.newArrayList(
            63, 52, 62, 0, 66, 0, 57, 51, 60
        );

        Integer maxJerseyNumber = Ordering.natural()
                                          .max(top10CentersNumbers);

        assertEquals(new Integer (66), maxJerseyNumber);

        // Java 8 - Stream API
        OptionalInt result = top10CentersNumbers.stream()
                                                .mapToInt(i -> i)
                                                .max();

        assertEquals(66, result.getAsInt());
    }

    // Order by length
    @Test
    public void order_elements_based_on_length () {

        Ordering<String> byLength = new Ordering<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Ints.compare(s1.length(), s2.length());
            }
        };

        List<String> famousBridges = Lists.newArrayList(
            "Great Belt Bridge",
            "Chapel Bridge",
            "Chengyang Bridge",
            "null2",
            "Brooklyn Bridge",
            "Ponte Vecchio"
        );

        Collections.sort(famousBridges, byLength.nullsFirst());

        log.info("order_elements_based_on_length :: {}", famousBridges);

        assertEquals("Great Belt Bridge", famousBridges.get(5));

        // Java 8 - Stream API
        Optional<String> result = famousBridges.stream()
                                               .sorted(comparingInt(String::length).reversed())
                                               .findFirst();

        assertEquals("Great Belt Bridge", result.get());
    }

    // Reverse elements
    @Test
    public void reverse_elements_in_list () {

        Ordering<String> byLength = new Ordering<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Ints.compare(s1.length(), s2.length());
            }
        };

        List<String> famousBridges = Lists.newArrayList(
            "Great Belt Bridge",
            "Chapel Bridge",
            "Chengyang Bridge",
            "null2",
            "Brooklyn Bridge",
            "Ponte Vecchio"
        );

        Collections.sort(famousBridges, byLength.nullsFirst().reverse());

        log.info("reverse_elements_in_list :: {}", famousBridges);

        assertEquals("Great Belt Bridge", famousBridges.get(0));

        // Java 8 - Stream API
        Optional<String> result = famousBridges.stream()
                                               .sorted(reverseOrder())
                                               .findFirst();

        assertEquals("null2", result.get());
    }

    // Least to greatest
    @Test
    public void order_list_of_integer_least_to_greatest () {

        List<Integer> startingLineUp = Lists.newArrayList(
            73, 58, 66, 57, 32, 88, 90, 12, 15, 99, 11
        );

        List<Integer> startingLineUpInOrder = Ordering
                .natural()
                .leastOf(startingLineUp, startingLineUp.size());

        log.info("order_list_of_integer_least_to_greatest :: {}", startingLineUpInOrder);

        assertEquals(new Integer(11), startingLineUpInOrder.get(0));

        // Java 8 - Stream API
        Optional<Integer> result = startingLineUp.stream()
                                                 .sorted()
                                                 .findFirst();

        assertEquals(Integer.valueOf(11), result.get());
    }

    // Greatest to least
    @Test
    public void order_list_of_integer_greatest_to_least () {

        List<Integer> startingLineUp = Lists.newArrayList(
            73, 58, 66, 57, 32, 88, 90, 12, 15, 99, 11
        );

        List<Integer> startingLineUpGreatestToLeast = Ordering
                .natural()
                .greatestOf(startingLineUp, startingLineUp.size());

        log.info("order_list_of_integer_greatest_to_least :; {}", startingLineUpGreatestToLeast);

        assertEquals(new Integer(99), startingLineUpGreatestToLeast.get(0));

        // Java 8 - Stream API
        Optional<Integer> result = startingLineUp.stream()
                                                 .sorted(reverseOrder())
                                                 .findFirst();

        assertEquals(Integer.valueOf(99), result.get());
    }


}
