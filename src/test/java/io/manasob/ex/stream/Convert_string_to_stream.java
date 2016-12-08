package io.manasob.ex.stream;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-08.
 */
public class Convert_string_to_stream {

    @Test
    public void string_to_stream() {

        String val = "Levelup Lunch";

        val.chars().forEach(
                e -> System.out.println(Character.toString((char) e)));

    }
}
