package io.manasobi.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by tw.jang on 2016-12-06.
 */
public class FunInterface_Ex01 {

    public static void main(String[] args) {

        // _____ Function _____
        Function<String, Integer> toInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        };

        Function<String, Integer> toInt2 = Integer::parseInt;

        Function<Integer, String> toInt3 = String::valueOf;

        System.out.println(toInt2.andThen(toInt3).apply("100"));
        System.out.println(toInt3.compose(toInt2).apply("200"));

        System.out.println(toInt.apply("123"));
        System.out.println(toInt2.apply("456"));

        // _____ Consumer _____
        Consumer<String> print = e -> System.out.println(e + " :: ");

        print.accept("TEST");

        // _____ Predicate _____
        Predicate<Integer> isPositive = e -> e > 0;

        System.out.println(isPositive.test(100));
        System.out.println(isPositive.test(0));

        List<Integer> numbers = Arrays.asList(-2, -1, 0, 1, 2);

        numbers = numbers.stream()
                         .filter(i -> i > -2)
                         .collect(Collectors.toList());

        System.out.println(numbers);
        System.out.println(filter(numbers, e -> e > -1));

        // _____ Supplier _____
        Supplier<String> helloSupplier = () -> "HELLO ";

        System.out.println(helloSupplier.get() + "WORLD");

        printValid(true, "TEST");

        long start = System.currentTimeMillis();

        printValid(true, getVeryExpensiveValue());
        printValid(false, getVeryExpensiveValue());
        printValid(false, getVeryExpensiveValue());

        System.out.println("Supplier 적용하지 않은 시간 :: " + (System.currentTimeMillis() - start) + " millis.");

        start = System.currentTimeMillis();

        printValidBySupplier(true, () -> getVeryExpensiveValue());
        printValidBySupplier(false, () -> getVeryExpensiveValue());
        printValidBySupplier(false, () -> getVeryExpensiveValue());

        System.out.println("Supplier 적용한 시간 :: " + (System.currentTimeMillis() - start) + " millis.");
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> filter) {

        return list.stream()
                   .filter(filter)
                   .collect(Collectors.toList());
    }

    private static String getVeryExpensiveValue() {

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "manasobi";
    }

    private static void printValid(boolean isTrue, String value) {

        if (isTrue) {
            System.out.println("This value is " + value);
        } else {
            System.out.println("Invalid");
        }
    }

    private static void printValidBySupplier(boolean isTrue, Supplier<String> stringSupplier) {

        if (isTrue) {
            System.out.println("This value is " + stringSupplier.get());
        } else {
            System.out.println("Invalid");
        }
    }

}
