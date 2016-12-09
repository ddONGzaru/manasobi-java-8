package io.manasob.ex.guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import static java.util.stream.Collectors.*;
import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by tw.jang on 2016-12-09.
 */
@Slf4j
public class Maps_utility_ex {

    @Data
    @AllArgsConstructor
    class State {
        String code;
        String name;
        String region;
        double population;
    }

    List<State> states;

    @Before
    public void setUp () {

        states = Lists.newArrayList();

        states.add(new State("WI", "Wisconsin",    "MDW",  5726398));
        states.add(new State("FL", "Florida",       "SE", 19317568));
        states.add(new State("IA", "Iowa",         "MDW",  3078186));
        states.add(new State("CA", "California",     "W", 38041430));
        states.add(new State("NY", "New York",      "NE", 19570261));
        states.add(new State("CO", "Colorado",       "W",  5187582));
        states.add(new State("OH", "Ohio",         "MDW", 11544225));
        states.add(new State("ME", "Maine",         "NE",  1329192));
        states.add(new State("SD", "South Dakota", "MDW",   833354));
        states.add(new State("TN", "Tennessee",     "SE",  6456243));
        states.add(new State("OR", "Oregon",         "W",  3899353));
    }

    // Initialize map
    @Test
    public void intialize_map () {

        Map<String, String> newMap = Maps.newHashMap();

        assertNotNull(newMap);
    }

    // Convert list to map
    @Test
    public void maps_unique_index() {

        Map<String, State> statesKeyByCode = Maps.uniqueIndex(states, state -> state.getCode());

        log.info("maps_unique_index ::");
        statesKeyByCode.entrySet().stream().forEach(System.out::println);

        assertThat(statesKeyByCode).containsKey("WI");

        // Java 8 - Stream API
        TreeMap<String, State> resultMap = Maps.newTreeMap();

        states.stream().forEach(state -> resultMap.put(state.getCode(), state));

        log.info("====================");
        resultMap.entrySet().stream().forEach(System.out::println);

        assertThat(resultMap).containsKey("WI");
    }

    // Convert properties to map
    @Test
    public void map_of_properties() {

        Properties properties = new Properties();
        properties.put("leveluplunch.java.examples",  "http://www.leveluplunch.com/java/examples/");
        properties.put("leveluplunch.java.exercises", "http://www.leveluplunch.com/java/exercises/");
        properties.put("leveluplunch.java.tutorials", "http://www.leveluplunch.com/java/tutorials/");

        Map<String, String> mapOfProperties = Maps.fromProperties(properties);

        log.info("map_of_properties :: {}", mapOfProperties);

        assertThat(mapOfProperties).containsKey("leveluplunch.java.examples");

        // Java 8 - Stream API
        Map<String, String> mapOfProperties2 = properties.entrySet().stream().collect(toMap(e -> e.getKey().toString(), e -> e.getValue().toString()));

        assertThat(mapOfProperties).containsKey("leveluplunch.java.exercises");
    }

    // Filter map by entries
    @Test
    public void maps_filter_entries() {

        // create a map
        Map<String, State> statesKeyByCode = Maps.uniqueIndex(states, state -> state.getCode());

        // filter entries
        Map<String, State> midwestStates = Maps.filterEntries(statesKeyByCode, entry -> entry.getValue().getRegion().equals("MDW"));

        log.info("maps_filter_entries :: {}", midwestStates);

        assertThat(midwestStates.keySet()).hasSize(4);
    }

    // Filter map by keys
    @Test
    public void map_filter_keys() {

        // create a map
        Map<String, State> statesKeyByCode = Maps.uniqueIndex(states, state -> state.getCode());

        Map<String, State> stateCodeWithVowelI = Maps.filterKeys(statesKeyByCode, stateCode -> stateCode.contains("I"));

        log.info("map_filter_keys :: {}", stateCodeWithVowelI);

        assertThat(stateCodeWithVowelI.keySet()).hasSize(2);
    }

    // Filter map by values
    @Test
    public void map_filter_by_values() {

        // create a map
        Map<String, State> statesKeyByCode = Maps.uniqueIndex(states, state -> state.getCode());

        Map<String, State> populationGT15Million = Maps.filterValues(statesKeyByCode, state -> state.getPopulation() >= 15000000);

        log.info("map_filter_by_values :: {}", populationGT15Million);

        assertThat(populationGT15Million.keySet()).hasSize(3);
    }

}
