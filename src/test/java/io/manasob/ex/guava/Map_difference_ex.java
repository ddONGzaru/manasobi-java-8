package io.manasob.ex.guava;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by tw.jang on 2016-12-09.
 */
@Slf4j
public class Map_difference_ex {

    @Data
    @AllArgsConstructor
    class Student {
        Integer id;
        String name;
    }

    Map<Integer, Student> geometryClass;
    Map<Integer, Student> gymClass;

    @Before
    public void setUp () {

        List<Student> geoStudents = Lists.newArrayList(
                new Student(123, "Jack Johnson"),
                new Student(456, "Cindy Lewis"),
                new Student(789, "Terry Peters"),
                new Student(912, "Ethan Nicks"),
                new Student(234, "Sarah Perry")
        );

        geometryClass = Maps.uniqueIndex(geoStudents, student -> student.getId());

        List<Student> gymStudents = Lists.newArrayList(
                new Student(123, "Jack Johnson"),
                new Student(478, "Patrick Ewig"),
                new Student(789, "Cindy Peters"),
                new Student(937, "Jon Lund"),
                new Student(234, "Sarah Perry")
        );

        gymClass = Maps.uniqueIndex(gymStudents, student -> student.getId());
    }

    // Entries in common
    @Test
    public void entries_in_common_or_intersection() {

        MapDifference<Integer, Student> mapDifference = Maps.difference(geometryClass, gymClass);

        Map<Integer, Student> commonStudents = mapDifference.entriesInCommon();

        log.info("entries_in_common_or_intersection :: {}", commonStudents);

        assertThat(commonStudents).containsKey(new Integer(234));
        assertThat(commonStudents).containsKey(new Integer(123));
    }

    // Entries that differ
    @Test
    public void entries_differing() {

        MapDifference<Integer, Student> mapDifference = Maps.difference(geometryClass, gymClass);

        System.out.println(mapDifference.entriesDiffering()); // with same keys

        Map<Integer, MapDifference.ValueDifference<Student>> sameKeyDifferentValue =
                mapDifference.entriesDiffering();

        assertThat(sameKeyDifferentValue.keySet()).contains(new Integer(789));
    }

    // Entries on the left
    @Test
    public void entries_only_on_left() {

        MapDifference<Integer, Student> mapDifference = Maps.difference(geometryClass, gymClass);

        Map<Integer, Student> studentsOnLeft = mapDifference.entriesOnlyOnLeft();

        log.info("entries_only_on_left :: {}", studentsOnLeft);

        assertThat(studentsOnLeft).containsKey(new Integer(456));
        assertThat(studentsOnLeft).containsKey(new Integer(912));
    }

    // Entries on the right
    @Test
    public void entries_only_on_right() {

        MapDifference<Integer, Student> mapDifference = Maps.difference(geometryClass, gymClass);

        Map<Integer, Student> studentsOnTheRight = mapDifference.entriesOnlyOnRight();

        log.info("entries_only_on_right :: {}", studentsOnTheRight);

        assertThat(studentsOnTheRight).containsKey(new Integer(478));
        assertThat(studentsOnTheRight).containsKey(new Integer(937));
    }
}
