package io.manasob.ex.guava;

import com.google.common.base.Enums;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by tw.jang on 2016-12-09.
 */
public class Enums_ex {

    enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    // Get field
    @Test
    public void enums_getfield () {

        Field field = Enums.getField(Day.FRIDAY);

        assertTrue(field.isEnumConstant());
    }

    // Get if present
    @Test
    public void enums_getIfPresent () {

        Optional<Day> friday = Enums.getIfPresent(Day.class, "FRIDAY");

        assertEquals(friday.get(), Day.FRIDAY);
    }

    // Value of function
    /*@Test
    public void enums_valueOfFunction () {

        Function<String, Day> valueOfFunction = Enums.valueOfFunction(Day.class);

        Day friday = valueOfFunction.apply("FRIDAY");

        assertEquals(friday, Day.FRIDAY);
    }*/

    // Transform string to enum
    /*@Test
    public void transform_string_to_enum () {

        List<String> days = Lists.newArrayList(
                "WEDNESDAY",
                "SUNDAY",
                "MONDAY",
                "TUESDAY",
                "WEDNESDAY");

        Function<String, Day> valueOfFunction = Enums.valueOfFunction(Day.class);

        Iterable<Day> daysAsEnums = Iterables.transform(days, valueOfFunction);

        assertThat(daysAsEnums, IsIterableWithSize.<Day>iterableWithSize(5));
        assertThat(daysAsEnums, IsIterableContainingInOrder.<Day>contains(Day.WEDNESDAY, Day.SUNDAY, Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY));
    }*/

    // String conveter
    /*@Test
    public void transform_string_to_enum_string_converter () {

        List<String> days = Lists.newArrayList(
                "WEDNESDAY",
                "SUNDAY",
                "MONDAY",
                "TUESDAY",
                "WEDNESDAY");

        Function<String, Day> valueOfFunction = Enums.stringConverter(Day.class);

        Iterable<Day> daysAsEnums = Iterables.transform(days, valueOfFunction);

        assertThat(daysAsEnums, IsIterableWithSize.<Day>iterableWithSize(5));
        assertThat(daysAsEnums, IsIterableContainingInOrder.
                <Day>contains(
                        Day.WEDNESDAY,
                        Day.SUNDAY,
                        Day.MONDAY,
                        Day.TUESDAY,
                        Day.WEDNESDAY));
    }*/
}
