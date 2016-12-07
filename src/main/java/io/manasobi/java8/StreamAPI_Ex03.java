package io.manasobi.java8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by tw.jang on 2016-12-07.
 */
public class StreamAPI_Ex03 {

    public static void main(String[] args) {

        System.out.println(
            Stream.of(1, 2, 3, 4, 5)
                  .filter(i -> i > 3)
                  .map(i -> i * 2)
                  .collect(Collectors.toList())
        );

        System.out.println(
            Stream.of(1, 2, 3, 4, 5)
                  .filter(i -> i > 3)
                  .map(i -> i * 2)
                  .findFirst()
        );
    }

}
