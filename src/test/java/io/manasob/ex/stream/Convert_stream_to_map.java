package io.manasob.ex.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by tw.jang on 2016-12-08.
 */
public class Convert_stream_to_map {

    List<Item> items;

    @Before
    public void setUp () {

        items = new ArrayList<>();

        items.add(new Item("ONE"));
        items.add(new Item("TWO"));
        items.add(new Item("THREE"));
    }

    @Test
    public void stream_to_map() {

        Map<String, Item> map = items.stream().collect(toMap(Item::getKey, item -> item));

        assertTrue(map.keySet().size() == 3);
    }

    static class Item {

        String key;

        public Item(String key) {
            super();
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }
}
