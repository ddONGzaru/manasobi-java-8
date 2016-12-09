package io.manasob.ex.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-09.
 */
public class Joiner_ex {

    // Join strings
    @Test
    public void join_a_list_of_strings () {

        List<String> cloudGroups = Lists.newArrayList(
                "Cirrus", "Alto", "Stratus",
                "Vertical Growth", "Special Clouds");

        String cloudGroupsJoined = Joiner.on(",").join(cloudGroups);

        assertEquals("Cirrus,Alto,Stratus,Vertical Growth,Special Clouds", cloudGroupsJoined);

        // Java 8 - Stream API
        String result = cloudGroups.stream().collect(joining(","));
        assertEquals("Cirrus,Alto,Stratus,Vertical Growth,Special Clouds", result);
    }

    // Join strings skipping null
    @Test
    public void join_a_list_of_strings_skipping_null () {

        List<String> cloudGroups = Lists.newArrayList(
                "Cirrus", "Alto", null, null,
                "Stratus", "Vertical Growth", "Special Clouds", null);

        String cloudGroupsJoined = Joiner.on(",").skipNulls().join(cloudGroups);

        assertEquals("Cirrus,Alto,Stratus,Vertical Growth,Special Clouds", cloudGroupsJoined);

        // Java 8 - Stream API
        String result = cloudGroups.stream().filter(s -> s != null).collect(joining(","));
        assertEquals("Cirrus,Alto,Stratus,Vertical Growth,Special Clouds", result);
    }

    // Join strings replacing null
    @Test
    public void join_a_list_of_strings_replacing_null () {

        List<String> cloudGroups = Lists.newArrayList(
                "Cirrus", "Alto", null, null,
                "Stratus", "Vertical Growth", "Special Clouds", null);

        String cloudGroupsJoined = Joiner.on(" and ")
                                         .useForNull("[unknown]")
                                         .join(cloudGroups);

        assertEquals("Cirrus and Alto and [unknown] and [unknown] and Stratus and Vertical Growth and Special Clouds and [unknown]", cloudGroupsJoined);

        // Java 8 - Stream API
        String result = cloudGroups.stream()
                                   .map(s -> s == null ? "[unknown]" : s)
                                   .collect(joining(" and "));

        assertEquals("Cirrus and Alto and [unknown] and [unknown] and Stratus and Vertical Growth and Special Clouds and [unknown]", result);
    }

    // Join map keys/values
    @Test
    public void join_key_values_map () {

        Multimap<String, String> clouds = ArrayListMultimap.create();

        clouds.put("Cirrus", "Cirrus");
        clouds.put("Cirrus", "Cirrostratus");
        clouds.put("Cirrus", "Cirrocumulus");

        clouds.put("Alto", "Altostratus");
        clouds.put("Alto", "Altocumulus");

        clouds.put("Stratus", "Stratus");
        clouds.put("Stratus", "Stratocumulus");
        clouds.put("Stratus", "Nimbostratus");

        clouds.put("Vertical Growth", "Cumulus");
        clouds.put("Vertical Growth", "Cumulonimbus");

        clouds.put("Special Clouds", "Mammatus");
        clouds.put("Special Clouds", "Lenticular");
        clouds.put("Special Clouds", "Fog");
        clouds.put("Special Clouds", "Contrails");

        String keysAndValuesJoined = Joiner.on(", ")
                                           .withKeyValueSeparator(" has type ")
                                           .join(clouds.entries());

        assertEquals("Cirrus has type Cirrus, "
                        + "Cirrus has type Cirrostratus, "
                        + "Cirrus has type Cirrocumulus, "
                        + "Vertical Growth has type Cumulus, "
                        + "Vertical Growth has type Cumulonimbus, "
                        + "Alto has type Altostratus, "
                        + "Alto has type Altocumulus, "
                        + "Stratus has type Stratus, "
                        + "Stratus has type Stratocumulus, "
                        + "Stratus has type Nimbostratus, "
                        + "Special Clouds has type Mammatus, "
                        + "Special Clouds has type Lenticular, "
                        + "Special Clouds has type Fog, "
                        + "Special Clouds has type Contrails",
                keysAndValuesJoined);

    }

}
