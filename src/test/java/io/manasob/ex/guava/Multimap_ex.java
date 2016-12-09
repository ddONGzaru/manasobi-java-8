package io.manasob.ex.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by tw.jang on 2016-12-09.
 */
@Slf4j
public class Multimap_ex {

    // Multimap
    @Test
    public void multipleMapExample_with_guava () {

        Multimap<String, String> outdoorElements = ArrayListMultimap.create();
        outdoorElements.put("fish", "walleye");
        outdoorElements.put("fish", "muskellunge");
        outdoorElements.put("fish", "bass");
        outdoorElements.put("insect", "ants");
        outdoorElements.put("insect", "water boatman");
        outdoorElements.put("insect", "Lord Howe Island stick insect");
        outdoorElements.put("tree", "oak");
        outdoorElements.put("tree", "birch");

        Collection<String> fishies = outdoorElements.get("fish");

        log.info("multipleMapExample_with_guava :: {}", fishies);

        assertTrue(fishies.size() == 3);
    }

    // Without guava
    @Test
    public void multiMap_example_straight_up_java () {

        Map<String, List<String>> outdoorElements = new HashMap<>();
        putObjects (outdoorElements, "fish", "walleye");
        putObjects (outdoorElements, "fish", "muskellunge");
        putObjects (outdoorElements, "fish", "bass");
        putObjects (outdoorElements, "insect", "ants");
        putObjects (outdoorElements, "insect", "water boatman");
        putObjects (outdoorElements, "insect", "Lord Howe Island stick insect");
        putObjects (outdoorElements, "tree", "oak");
        putObjects (outdoorElements, "tree", "birch");

        Collection<String> fishies = outdoorElements.get("fish");

        log.info("multiMap_example_straight_up_java :: {}", fishies);

        assertTrue(fishies.size() == 3);
    }

    private void putObjects (Map<String, List<String>> outdoorElements, String key, String value) {

        List<String> myClassList = outdoorElements.get(key);

        if(myClassList == null) {
            myClassList = new ArrayList<>();
            outdoorElements.put(key, myClassList);
        }

        myClassList.add(value);
    }

}
