package io.manasobi.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * Created by tw.jang on 2016-12-11.
 */
public class StreamAPI_maxBy {

    @Data
    @AllArgsConstructor
    static class Student {
        private int age;
        private String city;
    }

    static List<Student> students = Arrays.asList(
        new Student(10, "seoul"),
        new Student(9, "busan"),
        new Student(8, "seoul"),
        new Student(6, "busan"),
        new Student(4, "seoul"),
        new Student(8, "seoul"),
        new Student(9, "busan"),
        new Student(7, "busan")
    );

    public static void main(String[] args) {


        /*
            Map<String, Optional<Item>> maxBy2 = items.stream()
                                                      .collect(groupingBy(Item::getName, maxBy(comparing(Item::getQty))));
        */

        final List<Student> resultList = students.stream()
                                              .collect(groupingBy(Student::getCity, maxBy(comparing(Student::getAge))))
                                              .values()
                                              .stream()
                                              .map(Optional::get)
                                              .collect(toList());
        System.out.println(resultList);

        final List<Student> resultList2 = students.stream()
                                              .collect(groupingBy(Student::getCity, minBy(comparing(Student::getAge))))
                                              .values()
                                              .stream()
                                              .map(Optional::get)
                                              .collect(toList());
        System.out.println(resultList2);

        final Map<String, IntSummaryStatistics> resultList3 = students.stream()
                                                                      .collect(groupingBy(Student::getCity, summarizingInt(Student::getAge)));
        System.out.println(resultList3);

        final Map<Boolean, List<Student>> resultList4 = students.stream()
                                                                .collect(partitioningBy(e -> e.getCity().equals("busan")));
        System.out.println(resultList4);
    }


}
