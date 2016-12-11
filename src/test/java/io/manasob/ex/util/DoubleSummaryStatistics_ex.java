package io.manasob.ex.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summarizingDouble;
import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-09.
 */
public class DoubleSummaryStatistics_ex {

    @Data
    @AllArgsConstructor
    class Company {
        double revenue;
    }

    List<Company> companies;

    @Before
    public void setUp() {
        companies = new ArrayList<>();
        companies.add(new Company(100.12));
        companies.add(new Company(142.65));
        companies.add(new Company(12.1));
        companies.add(new Company(184.90));
    }

    // Compute summary statistics on a stream
    @Test
    public void double_summary_stats_with_stream() {

        DoubleSummaryStatistics stats = companies.stream()
                                                 .mapToDouble(Company::getRevenue)
                                                 .summaryStatistics();

        // average
        assertEquals(109.9425, stats.getAverage(), 0);

        // count
        assertEquals(4, stats.getCount(), 0);

        // max
        assertEquals(184.9, stats.getMax(), 0);

        // min
        assertEquals(12.1, stats.getMin(), 0);

        // sum
        assertEquals(439.77, stats.getSum(), 0);
    }

    // DoubleSummaryStatistics as a reduction target
    @Test
    public void double_summary_stats_stream_reduction_target() {

        DoubleSummaryStatistics stats = companies.stream().collect(summarizingDouble(Company::getRevenue));

        // average
        assertEquals(109.9425, stats.getAverage(), 0);

        // count
        assertEquals(4, stats.getCount(), 0);

        // max
        assertEquals(184.9, stats.getMax(), 0);

        // min
        assertEquals(12.1, stats.getMin(), 0);

        // sum
        assertEquals(439.77, stats.getSum(), 0);
    }

}
