package io.manasobi.java8;

import java.math.BigDecimal;

/**
 * Created by tw.jang on 2016-12-07.
 */
public class FunInterface_Ex03 {

    public static void main(String[] args) {

        BigDecimalToCurrency bigDecimalToCurrency = e -> "$ " + e.toString();

        System.out.println(bigDecimalToCurrency.toCurrency(BigDecimal.TEN));
    }

    @FunctionalInterface
    interface BigDecimalToCurrency {

        String toCurrency(BigDecimal value);
    }

}

