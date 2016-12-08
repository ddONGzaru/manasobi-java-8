package io.manasobi.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

/**
 * Created by tw.jang on 2016-12-07.
 */
public class StreamAPI_Ex06 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("Hello");
        list.add("World");

        Map<String, Long> counted = list.stream()
                                        .collect(groupingBy(Function.identity(), counting()));

        System.out.println(counted);

    }

}
