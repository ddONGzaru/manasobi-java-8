package io.manasob.ex.guava;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-09.
 */
public class RangeMap_ex {

    @Test
    public void google_guava_range_map_example () {

        RangeMap<Integer, String> gradeScale = TreeRangeMap.create();

        gradeScale.put(Range.closed(0, 60), "F");
        gradeScale.put(Range.closed(61, 70), "D");
        gradeScale.put(Range.closed(71, 80), "C");
        gradeScale.put(Range.closed(81, 90), "B");
        gradeScale.put(Range.closed(91, 100), "A");

        String grade = gradeScale.get(77);

        assertEquals("C", grade);
    }
}
