package io.manasob.ex.guava;

import com.google.common.collect.Lists;
import one.util.streamex.StreamEx;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by tw.jang on 2016-12-09.
 */
public class Lists_utility_ex {

    // Create new list
    @Test
    public void create_new_list () {

        List<String> myList = Lists.newArrayList();

        assertNotNull(myList);
    }

    // Create new list w/ parameters
    @Test
    public void create_new_list_with_parameters () {

        List<String> myList = Lists.newArrayList("one", "two");

        assertNotNull(myList);
    }

    // Create list with capacity
    @Test
    @Ignore
    public void create_new_list_with_capacity () {

        List<String> listWithSize10 = Lists.newArrayListWithCapacity(10);

        listWithSize10.add(10, "TEST");

        assertNotNull(listWithSize10);
        assertEquals(1, listWithSize10.size());
    }

    // Create new list w/ expected size
    @Test
    @Ignore
    public void create_new_list_with_expected_size () {

        List<String> listWithSize10 = Lists.newArrayListWithExpectedSize(10);

        listWithSize10.add(10, "TEST");

        assertNotNull(listWithSize10);
        assertEquals(1, listWithSize10.size());
    }

    // Unmodifiable list
    @Test
    public void create_new_unmodified_list () {

        String[] vals = {"test1", "test2"};
        List<String> myList = Lists.asList("test0", vals);

        assertNotNull(myList);
    }

    // Parition list
    @Test
    public void partition_list () {

        List<String> myList = Lists.newArrayList("one", "two", "three");

        List<List<String>> myListBy1 = Lists.partition(myList, 2);

        assertThat(myListBy1.get(0), hasItems("one", "two"));
        assertThat(myListBy1.get(1), hasItems("three"));

        // Java 8 - Stream API
        List<List<String>> myListBy2 = StreamEx.of(myList).ofSubLists(myList, 2).collect(toList());

        assertThat(myListBy2.get(0), hasItems("one", "two"));
        assertThat(myListBy2.get(1), hasItems("three"));
    }

    // Reverse list
    @Test
    public void reverse_list () {

        List<String> myList = Lists.newArrayList("one", "two", "three");

        List<String> reverseMyList = Lists.reverse(myList);

        org.assertj.core.api.Assertions.assertThat(reverseMyList).contains("three", "two", "one");

        // Java 8 - Stream API
        List<String> reverseMyList2 = myList.stream().sorted(reverseOrder()).collect(toList());

        org.assertj.core.api.Assertions.assertThat(reverseMyList2).contains("three", "two", "one");
    }

}
