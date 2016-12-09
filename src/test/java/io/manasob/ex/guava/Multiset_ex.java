package io.manasob.ex.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-09.
 */
@Slf4j
public class Multiset_ex {

    // Count elements in set
    @Test
    public void multiset_example () {

        Multiset<String> camouflage = HashMultiset.create();
        camouflage.add("Realtree APG");
        camouflage.add("Realtree Hardwoods HD");
        camouflage.add("Realtree APG");
        camouflage.add("Realtree Hardwoods Green HD");
        camouflage.add("Mossy Oak New Break-Up");
        camouflage.add("Realtree APG");

        log.info("multiset_example :: {}", camouflage);

        int numberOfRealTrees = camouflage.count("Realtree APG");

        assertEquals(3, numberOfRealTrees);
    }

}
