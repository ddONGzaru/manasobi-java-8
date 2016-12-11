package io.manasob.ex.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summarizingInt;
import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-09.
 */
public class IntSummaryStatistics_ex {

    @Data
    @AllArgsConstructor
    class OrderEntry {
        int amount;
    }

    List<OrderEntry> orderEntries;

    @Before
    public void setUp() {
        orderEntries = new ArrayList<>();
        orderEntries.add(new OrderEntry(10));
        orderEntries.add(new OrderEntry(14));
        orderEntries.add(new OrderEntry(12));
        orderEntries.add(new OrderEntry(18));
    }

    // Compute summary statistics on a stream
    @Test
    public void test_methods() {

        IntSummaryStatistics stats = orderEntries.stream()
                                                 .mapToInt(OrderEntry::getAmount)
                                                 .summaryStatistics();

        // average
        assertEquals(13.5, stats.getAverage(), 0);

        // count
        assertEquals(4, stats.getCount(), 0);

        // max
        assertEquals(18, stats.getMax(), 0);

        // min
        assertEquals(10, stats.getMin(), 0);

        // sum
        assertEquals(54, stats.getSum(), 0);
    }

    // IntSummaryStatistics as a reduction target
    @Test
    public void int_summary_stats_stream_reduction_target() {

        IntSummaryStatistics stats = orderEntries.stream()
                                                 .collect(summarizingInt(OrderEntry::getAmount));

        // average
        assertEquals(13.5, stats.getAverage(), 0);

        // count
        assertEquals(4, stats.getCount(), 0);

        // max
        assertEquals(18, stats.getMax(), 0);

        // min
        assertEquals(10, stats.getMin(), 0);

        // sum
        assertEquals(54, stats.getSum(), 0);
    }

}
