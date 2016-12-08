package io.manasob.ex.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-08.
 */
@Slf4j
public class Stream_grouping_by {

    /*
    SELECT column_name, count(column_name)
    FROM table
    GROUP BY column_name;
    */

    @Data
    @AllArgsConstructor
    class StudentClass {
        private String teacher;
        private double level;
        private String className;
    }

    private List<StudentClass> studentClasses;

    @Before
    public void setUp() {

        studentClasses = new ArrayList<>();

        studentClasses.add(new StudentClass("Kumar",   101, "Intro to Web"));
        studentClasses.add(new StudentClass("White",   102, "Advanced Java"));
        studentClasses.add(new StudentClass("Kumar",   101, "Intro to Cobol"));
        studentClasses.add(new StudentClass("Sargent", 101, "Intro to Web"));
        studentClasses.add(new StudentClass("Sargent", 102, "Advanced Web"));
    }

    // Group by teacher name
    @Test
    public void group_by_teacher_name() {

        Map<String, List<StudentClass>> groupByTeachers = studentClasses.stream()
                                                                        .collect(groupingBy(StudentClass::getTeacher));

        log.info("group_by_teacher_name :: {}", groupByTeachers);

        assertEquals(1, groupByTeachers.get("White").size());
    }

    // Group by class level
    @Test
    public void group_by_level() {

        Map<Double, List<StudentClass>> groupByLevel = studentClasses.stream()
                                                                     .collect(groupingBy(StudentClass::getLevel));

        log.info("group_by_level :: {}", groupByLevel);

        assertEquals(3, groupByLevel.get(101.0).size());
    }

    // groupBy aggregate
    @Test
    public void group_by_count() {

        Map<String, Long> groupByLevel = studentClasses.stream()
                                                       .collect(groupingBy(StudentClass::getTeacher, counting()));

        log.info("group_by_count :: {}", groupByLevel);

        assertEquals(Long.valueOf(2L), groupByLevel.get("Sargent"));
    }
}
