package io.manasob.ex.guava;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

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

    // Numbers ordered
    @Test
    public void is_list_of_numbers_sorted_in_java_with_guava () {

        List<Integer> uwConferenceTitles = Lists.newArrayList(
                1896, 1897, 1901, 1906, 1912,
                1952, 1959, 1962, 1993, 1998,
                1999, 2010, 2011, 2012);

        boolean isSorted = Ordering.natural()
                                   .isOrdered(uwConferenceTitles);

        assertTrue(isSorted);
    }

    // Strings ordered
    @Test
    public void is_list_of_strings_sorted_in_java_with_guava () {

        List<String> secConferenceEast = Lists.newArrayList("Florida", "Georgia", "Missouri", "South Carolina", "Tennessee", "Vanderbilt");

        boolean isSorted = Ordering.natural()
                                   .isOrdered(secConferenceEast);

        assertTrue(isSorted);
    }

    // Strings ordered case insensitive
    @Test
    public void is_list_of_strings_sorted_case_insensitive_in_java_with_guava () {

        List<String> secConferenceEast = Lists.newArrayList(
                "alabama",
                "Alabama",
                "ALABAMA");

        boolean isSorted = Ordering.from(String.CASE_INSENSITIVE_ORDER)
                                   .isOrdered(secConferenceEast);

        assertTrue(isSorted);
    }

    // Order by object field
    @Data
    @AllArgsConstructor
    class GlassWare {
        private String name;
        private String description;
    }

    @Test
    public void order_by_object_field () {

        List<GlassWare> beerGlasses = Lists.newArrayList(
            new GlassWare("Flute Glass", "Enhances and showcases..."),
            new GlassWare("Pilsner Glass (or Pokal)", "showcases color, ..."),
            new GlassWare("Pint Glass", "cheap to make..."),
            new GlassWare("Goblet (or Chalice)", "Eye candy..."),
            new GlassWare("Mug (or Seidel, Stein)", "Easy to drink...")/*,
            new GlassWare(null, null)*/
        );

        /*Ordering<GlassWare> byGlassWareName = Ordering.natural().nullsFirst()
                .onResultOf(new Function<GlassWare, String>() {
                    public String apply(GlassWare glassWare) {
                        return glassWare.getName();
                    }
                });

        GlassWare firstBeerGlass = byGlassWareName.min(beerGlasses);

        // first element will be null
        assertNull(firstBeerGlass.getName());

        GlassWare lastBeerGlass = byGlassWareName.max(beerGlasses);
        assertEquals("Pint Glass", lastBeerGlass.getName());*/


        beerGlasses.stream()
                .sorted(comparing(GlassWare::getName))
                .forEach(System.out::println);

        beerGlasses.stream()
                .sorted(comparing(GlassWare::getName).reversed())
                .forEach(System.out::println);
    }





}
