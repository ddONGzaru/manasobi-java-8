package io.manasob.ex.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-08.
 */
public class Stream_reduce {

    @Data
    @AllArgsConstructor
    class Precipitation {
        private LocalDate occurrence;
        private double amount;
    }

    List<Precipitation> precip;

    @Before
    public void setUp() {

        precip = new ArrayList<>();

        precip.add(new Precipitation(LocalDate.of(2014, Month.JANUARY, 7),    .25));
        precip.add(new Precipitation(LocalDate.of(2014, Month.FEBRUARY, 9),   .10));
        precip.add(new Precipitation(LocalDate.of(2014, Month.FEBRUARY, 15),  .50));
        precip.add(new Precipitation(LocalDate.of(2014, Month.MARCH, 9),     1.09));
    }

    // sum
    @Test
    public void sum_elements() {

        double totalPrecipYear = precip.stream()
                                       .mapToDouble(Precipitation::getAmount)
                                       .sum();

        assertEquals(1.9399999999999997, totalPrecipYear, 0);

        // or
        OptionalDouble totalPrecipYear2 = precip.stream()
                                                .mapToDouble(Precipitation::getAmount)
                                                .reduce(Double::sum);

        assertEquals(1.94, totalPrecipYear2.getAsDouble(), 0);

        // or
        double totalPrecipYear3 = precip.stream()
                                        .mapToDouble(Precipitation::getAmount)
                                        .reduce(0, (a, b) -> a + b);

        assertEquals(1.94, totalPrecipYear3, 0);
    }

    // max
    @Test
    public void max_elements() {

        OptionalDouble max = precip.stream()
                                   .mapToDouble(Precipitation::getAmount)
                                   .max();

        assertEquals(1.09, max.getAsDouble(), 0);

        // or

        OptionalDouble max2 = precip.stream()
                                    .mapToDouble(Precipitation::getAmount)
                                    .reduce(Double::max);

        assertEquals(1.09, max2.getAsDouble(), 0);
    }

    // min
    @Test
    public void min_elements() {

        OptionalDouble min = precip.stream()
                                   .mapToDouble(Precipitation::getAmount)
                                   .min();

        assertEquals(1.09, min.getAsDouble(), 0);

        // or

        OptionalDouble min2 = precip.stream()
                                    .mapToDouble(Precipitation::getAmount)
                                    .reduce(Double::min);

        assertEquals(1.09, min2.getAsDouble(), 0);
    }

    // average
    @Test
    public void average_of_elements() {

        OptionalDouble average = precip.stream()
                                       .mapToDouble(Precipitation::getAmount)
                                       .average();

        assertEquals(0.48499999999999993, average.getAsDouble(), 0);
    }

    // count
    @Test
    public void count_elements() {

        long numberOfElements = precip.stream()
                                      .mapToDouble(Precipitation::getAmount)
                                      .count();

        assertEquals(4.0, numberOfElements, 0);
    }

}
