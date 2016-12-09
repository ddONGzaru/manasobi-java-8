package io.manasob.ex.guava;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-09.
 */
@Slf4j
public class Collection2_utility_ex {

    // Filter
    @Test
    public void filter () {

        List<String> strings = Lists.newArrayList(null, "www", null, "leveluplunch", "com", null);


        Collection<String> filterStrings = Collections2.filter(
                strings, new Predicate<String>() {
                    @Override
                    public boolean apply(String input) {
                        return input != null && input.length() >= 3;
                    }
                });

        log.info("filter :: {}", filterStrings);

        assertEquals(3, filterStrings.size());

        // Java 8 - Stream API
        List<String> strings2 = Lists.newArrayList(null, "www", null, "leveluplunch", "com", null);

        strings2 = strings2.stream()
                           .filter(s -> s != null && s.length() >= 3)
                           .collect(toList());

        log.info("filter :: {}", strings2);
    }

    // Ordered Permutations
    @Test
    public void ordered_permutations () {

        List<Integer> vals = Lists.newArrayList(1, 2, 3);

        Collection<List<Integer>> orderPerm = Collections2.orderedPermutations(vals);

        for (List<Integer> val : orderPerm) {
            log.info("ordered_permutations :: {}", val);
        }

        assertEquals(6, orderPerm.size());
    }

    // Permutations
    @Test
    public void permutations () {

        List<Integer> vals = Ints.asList(new int[] {1, 2, 3});

        Collection<List<Integer>> orderPerm = Collections2.permutations(vals);

        for (List<Integer> val : orderPerm) {
            log.info("permutations :: {}", val);
        }

        assertEquals(6, orderPerm.size());
    }

    // Transform
    @Test
    public void transform () {

        List<String> numbersAsStrings = Lists.newArrayList("1", "2", "3");

        Collection<Double> doubles = Collections2.transform(
                numbersAsStrings, new Function<String, Double>() {
                    @Override
                    public Double apply(String input) {
                        return new Double(input);
                    }
                });

        assertThat(doubles).contains(new Double(1), new Double(2), new Double(3));

        // Java 8 - Stream API
        assertThat(numbersAsStrings.stream().map(Double::valueOf).collect(toList()))
                .contains(new Double(1), new Double(2), new Double(3));
    }

}
