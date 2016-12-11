package io.manasobi.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * Created by tw.jang on 2016-12-11.
 */
public class StreamAPI_grouping_partioning {

    public static void main(String[] args) {

        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
            new Item("apple",      11,  new BigDecimal("9.99")),
            new Item("banana",     22, new BigDecimal("19.99")),
            new Item("orange",      13, new BigDecimal("29.99")),
            new Item("watermelon", 14, new BigDecimal("29.99")),
            new Item("papaya",     25,  new BigDecimal("9.99")),
            new Item("apple",      16,  new BigDecimal("9.99")),
            new Item("banana",     17, new BigDecimal("19.99")),
            new Item("apple",      28,  new BigDecimal("9.99"))
        );

        Map<String, List<Item>> itemList = items.stream().collect(groupingBy(Item::getName));

        System.out.println("===== groupingBy :: item - list =====");
        itemList.entrySet().stream()
                           .sorted(comparing(e -> e.getKey()))
                           .forEach(e -> System.out.println(e.getKey() + " :: " + e.getValue()));
        System.out.println();


        Map<String, Set<Item>> itemSet = items.stream().collect(groupingBy(Item::getName, toSet()));

        System.out.println("===== groupingBy :: item - set =====");
        itemSet.entrySet().stream()
                .sorted(comparing(e -> e.getKey()))
                .forEach(e -> System.out.println(e.getKey() + " :: " + e.getValue()));
        System.out.println();


        Map<String, Long> counting = items.stream().collect(groupingBy(Item::getName, counting()));

        System.out.println("===== counting =====");
        System.out.println(counting);
        System.out.println();

        Map<String, Integer> summingInt = items.stream().collect(groupingBy(Item::getName, summingInt(Item::getQty)));

        System.out.println("===== summingInt =====");
        System.out.println(summingInt);
        System.out.println();

        Map<String, Double> summingDouble = items.stream().collect(groupingBy(Item::getName, summingDouble(e -> e.getPrice().doubleValue())));

        System.out.println("===== summingDouble =====");
        System.out.println(summingDouble);
        System.out.println();

    }

    @Data
    @AllArgsConstructor
    static class Item {

        private String name;
        private int qty;
        private BigDecimal price;
    }

}


