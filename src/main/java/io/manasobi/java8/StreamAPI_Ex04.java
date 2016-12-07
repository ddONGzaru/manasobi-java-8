package io.manasobi.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created by tw.jang on 2016-12-07.
 */
public class StreamAPI_Ex04 {

    public static void main(String[] args) {

        List<String> phrases = Arrays.asList(
                "sporadic perjury",
                "confounded skimming",
                "incumbent jailer",
                "confounded jailer");

        List<String> uniqueWords = phrases.stream()
                                          .flatMap(phrase -> Stream.of(phrase.split(" ")))
                                          .distinct()
                                          .sorted()
                                          .collect(toList());

        System.out.println("Unique words: " + uniqueWords);

        System.out.println(
            Stream.of(1, 2, 3, 4, 5)
                  .filter(i -> i > 2)
                  .map(i -> "# " + i)
                  .collect(joining(" : "))
        );

        System.out.println(
            Stream.of(1, 2, 3, 3, 3)
                  .filter(i -> i > 0)
                  .distinct()
                  .map(i -> "# " + i)
                  .collect(joining(" : ", "@@ ", " @@"))
        );

        System.out.println(
            Stream.of(1, 2, 3, 3, 3)
                  .map(i -> "# " + i)
                  .collect(toSet())
        );

        System.out.println(
            Stream.of(1, 2, 3, 3, 3)
                  .map(i -> "# " + i)
                  .distinct()
                  .collect(toList())
        );

        System.out.println(
            Stream.of(1, 2, 3, 4, 5)
                  .filter(i -> i.equals(3))
                  .findFirst()
        );

        System.out.println(
            Stream.of(1, 2, 3, 4, 5)
                  .filter(i -> i > 3)
                  .count()
        );

    }


}
