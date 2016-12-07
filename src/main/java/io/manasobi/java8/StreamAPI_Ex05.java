package io.manasobi.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 * Created by tw.jang on 2016-12-07.
 */
public class StreamAPI_Ex05 {

    public static void main(String[] args) {

        List<Product> products =
            Arrays.asList(
                new Product(1L, "A", new BigDecimal("100.50")),
                new Product(2L, "B", new BigDecimal("23.00")),
                new Product(3L, "C", new BigDecimal("31.45")),
                new Product(4L, "D", new BigDecimal("80.20")),
                new Product(5L, "E", new BigDecimal("7.50"))
            );

        System.out.println("Products.price >= 30: \n" +
            products.stream()
                    .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                    .collect(toList())
        );

        System.out.println("==================================================");
        System.out.println("Products.price >= 30 (with joining): \n" +
            products.stream()
                    .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                    .map(product -> product.toString())
                    .collect(joining("\n"))
        );

        System.out.println("==================================================");
        System.out.println("IntStream.sum: " +
            IntStream.of(1, 2, 3, 4, 5)
                     .sum()
        );

        System.out.println("==================================================");
        System.out.println("Total Price: " +
            products.stream()
                    .map(product -> product.getPrice())
                    .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))

        );

        System.out.println("==================================================");
        System.out.println("Total Price (IntStream): " +
            products.stream()
                    .map(product -> product.getPrice().doubleValue())
                    .mapToDouble(Double::valueOf)
                    .sum()
        );

        System.out.println("==================================================");
        System.out.println("Total Price (IntStream + identity fun): " +
            products.stream()
                    .map(product -> product.getPrice().doubleValue())
                    .mapToDouble(x -> x)
                    .sum()
        );

        System.out.println("==================================================");
        System.out.println("Total Price (After Filter price >= 30): " +
            products.stream()
                    .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                    .map(product -> product.getPrice().doubleValue())
                    .mapToDouble(Double::valueOf)
                    .sum()
        );

        System.out.println("==================================================");
        System.out.println("Total Count (price >= 30): " +
            products.stream()
                    .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                    .count()
        );

        OrderedItem orderedItem1 = new OrderedItem(1L, products.get(0), 1);
        OrderedItem orderedItem2 = new OrderedItem(2L, products.get(2), 3);
        OrderedItem orderedItem3 = new OrderedItem(3L, products.get(4), 10);

        Order order = new Order(1L, Arrays.asList(orderedItem1, orderedItem2, orderedItem3));

        System.out.println("==================================================");
        System.out.println("Total Price In Order: " + order.getTotalPrice());

    }

    @Data
    @AllArgsConstructor
    static class Product {
        private Long id;
        private String name;
        private BigDecimal price;
    }

    @Data
    @AllArgsConstructor
    static class OrderedItem {
        private Long id;
        private Product product;
        private int quantity;

        public BigDecimal getTotalPrice() {
            return product.getPrice().multiply(new BigDecimal(quantity));
        }
    }

    @Data
    @AllArgsConstructor
    static class Order {
        private Long id;
        private List<OrderedItem> items;

        public BigDecimal getTotalPrice() {
            return items.stream()
                        .map(orderedItem -> orderedItem.getTotalPrice())
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }

}
