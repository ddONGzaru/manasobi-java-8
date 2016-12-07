package io.manasobi.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by tw.jang on 2016-12-07.
 */
public class FunInterface_Ex04 {

    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
            new Product(1L, "A", new BigDecimal("10.00")),
            new Product(2L, "B", new BigDecimal("20.00")),
            new Product(3L, "C", new BigDecimal("30.00")),
            new Product(4L, "D", new BigDecimal("40.00")),
            new Product(5L, "E", new BigDecimal("50.00"))
        );


        List<Product> result = new ArrayList<>();

        for (Product product : products) {

            if (product.getPrice().compareTo(new BigDecimal("30")) > 0) {
                result.add(product);
            }
        }

        System.out.println(result);

        Predicate<Product> filterCondition = product -> product.getPrice().compareTo(new BigDecimal("30")) > 0;

        List<Product> funResult =
                filter(products, filterCondition);

        System.out.println(funResult);

        List<DiscountedProduct> discountedProducts =
                map(funResult, product -> new DiscountedProduct(product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5"))));

        System.out.println(discountedProducts);

        List<BigDecimal> prices = map(products, product -> product.getPrice());

        BigDecimal totalPrice = BigDecimal.ZERO;

        for (BigDecimal price : prices) {
            totalPrice = totalPrice.add(price);
        }

        System.out.println(totalPrice);

        System.out.println(total(products, product -> product.getPrice()));

    }

    private static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {

        List<T> resultTList = new ArrayList<T>();

        for (T t : list) {
            if (predicate.test(t)) {
                resultTList.add(t);
            }
        }

        return resultTList;
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> fun) {

        List<R> resultTList = new ArrayList<>();

        for (T t : list) {
            resultTList.add(fun.apply(t));
        }

        return resultTList;
    }

    private static <T> BigDecimal total(List<T> list, Function<T, BigDecimal> fun) {

        BigDecimal totalPrice = BigDecimal.ZERO;

        for (T t : list) {
            totalPrice = totalPrice.add(fun.apply(t));
        }

        return totalPrice;
    }

    @Data
    @AllArgsConstructor
    static class Product {

        private Long id;
        private String name;
        private BigDecimal price;
    }

    @ToString(callSuper = true)
    static class DiscountedProduct extends Product {

        public DiscountedProduct(Long id, String name, BigDecimal price) {
            super(id, name, price);
        }
    }

}

