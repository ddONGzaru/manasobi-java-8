package io.manasobi.java8;

/**
 * Created by tw.jang on 2016-12-06.
 */
public class FunInterface_Ex02 {

    public static void main(String[] args) {

        println("Area is ", 100, 20, (message, length, width) -> String.valueOf(message + (length * width)));
    }

    private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, Fun3<T1, T2, T3, String> f) {
        String result = f.apply(t1, t2, t3);
        System.out.println("Result :: " + result);
    }

    @FunctionalInterface
    interface Fun3<T1, T2, T3, R> {

        R apply(T1 t1, T2 t2, T3 t3);
    }
}

