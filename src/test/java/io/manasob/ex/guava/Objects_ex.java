package io.manasob.ex.guava;

import com.google.common.base.Objects;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by tw.jang on 2016-12-09.
 */
public class Objects_ex {

    // To string helper
    @Test
    public void to_string_helper () {

        String overRideToString = Objects.toStringHelper(this)
                .add("name", "value")
                .toString();

        assertEquals("Objects_ex{name=value}", overRideToString);
    }

    // Equal
    @Test
    public void objects_equals () {

        String value1 = "Ice cold beer fest";
        String value2 = "Ice cold beer fest 2013";

        boolean objectEqual = Objects.equal(value1, value2);
        assertFalse(objectEqual);
    }

    // First non null
    @Test
    public void first_non_null () {

        String first = null;
        String second = "What's shakin' bacon?";

        String firstNullObject = Objects.firstNonNull(first, second);

        assertEquals(second, firstNullObject);
    }

    // Hash code
    @Test
    public void object_hashcode () {

        int hashCode = Objects.hashCode(this);

        System.out.println(hashCode);

        assertNotNull(hashCode);
    }


}
