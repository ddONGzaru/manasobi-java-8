package io.manasob.ex.guava;

import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by tw.jang on 2016-12-09.
 */
public class Booleans_utility_ex {

    // Array contains
    @Test
    public void boolean_array_contains () {

        boolean[] booleanArray = {true, false, true, false};

        boolean arrayContains = Booleans.contains(booleanArray, true);

        assertTrue(arrayContains);
    }

    // Find index of element
    @Test
    public void boolean_array_index () {

        boolean[] booleanArray = {true, false, true, false};

        int index = Booleans.indexOf(booleanArray, false);

        assertEquals(1, index);
    }

    // Combine two boolean arrays
    @Test
    public void concat_boolean_arrays () {

        boolean[] booleanArray1 = {true, false};
        boolean[] booleanArray2 = {true, false};

        boolean[] concatedArray = Booleans.concat(booleanArray1, booleanArray2);

        assertEquals(4, concatedArray.length);
    }

    // Convert primitive array to list
    @Test
    public void convert_boolean_array_to_Boolean_list () {

        boolean[] booleanArray = {true, false, true, false};

        List<Boolean> booleans = Booleans.asList(booleanArray);

        assertEquals(4, booleans.size());

        int[] intArray = {1, 2, 3, 4, 5};

        List<Integer> ints = Ints.asList(intArray);

        assertEquals(5, ints.size());
    }

    // Convert list to primitive array
    @Test
    public void convert_Boolean_to_primitive () {

        List<Boolean> booleans = Lists.newArrayList(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE);

        boolean[] primitiveArray = Booleans.toArray(booleans);

        assertEquals(4, primitiveArray.length);

        List<Integer> ints = Lists.newArrayList(1, 2, 3, 4, 5);

        int[] intArray = Ints.toArray(ints);

        assertEquals(5, intArray.length);
    }

    // Count number of booleans
    @Test
    public void count_total_number_of_booleans () {

        boolean [] values = {true, true, false, true, false};

        int count = Booleans.countTrue(values);

        assertEquals(3, count);
    }

    //Join array elements as string
    @Test
    public void join_elements_of_boolean_array () {

        boolean[] booleanArray = {true, false, true, false};

        String joinedElements = Booleans.join("-", booleanArray);

        assertEquals("true-false-true-false", joinedElements);
    }

}
