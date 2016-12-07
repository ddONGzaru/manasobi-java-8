package io.manasobi.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by tw.jang on 2016-12-07.
 */
public class StreamAPI_Ex01 {

    // Identity Function 활용 예.

    public static void main(String[] args) {
        int abs1 = Math.abs(-1);
        int abs2 = Math.abs(1);

        System.out.println("abs1 == abs2 is " + (abs1 == abs2));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(map(numbers, e -> e * 2));
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {

        List<R> resultList = new ArrayList<>();

        for (T t : list) {
            resultList.add(mapper.apply(t));
        }

        return resultList;
    }


}
