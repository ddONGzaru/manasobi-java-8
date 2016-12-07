package io.manasobi.java8;

import java.util.stream.IntStream;

/**
 * Created by tw.jang on 2016-12-07.
 */
public class StreamAPI_Ex02 {

    public static void main(String[] args) {

        IntStream.range(1, 10).forEach(i -> System.out.print(i + " "));
        System.out.println();
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.print(i + " "));

    }

}
