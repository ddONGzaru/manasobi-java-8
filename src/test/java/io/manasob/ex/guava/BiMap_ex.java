package io.manasob.ex.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by tw.jang on 2016-12-09.
 */
public class BiMap_ex {

    // Google Guava
    @Test
    public void bidirectional_map_with_guava () {

        BiMap<String, String> dialectConverterForWisconsinites = HashBiMap.create();

        dialectConverterForWisconsinites.put("bratwurst", "brat");
        dialectConverterForWisconsinites.put("drinking fountain", "bubbler");
        dialectConverterForWisconsinites.put("that", "dat");
        dialectConverterForWisconsinites.put("alright", "iet");
        dialectConverterForWisconsinites.put("soda", "pop");

        BiMap<String, String> dialectConverterForEveryoneElse = dialectConverterForWisconsinites.inverse();

        assertNotNull(dialectConverterForEveryoneElse.get("brat"));
    }

    // Straight up Java
    @Test
    public void bidirectional_map_with_java () {

        Map<String,String> dialectConverterForWisconsinites = new HashMap<String,String>();
        dialectConverterForWisconsinites.put("bratwurst", "brat");
        dialectConverterForWisconsinites.put("drinking fountain", "bubbler");
        dialectConverterForWisconsinites.put("that", "dat");
        dialectConverterForWisconsinites.put("alright", "iet");
        dialectConverterForWisconsinites.put("soda", "pop");

        Map<String,String> dialectConverterForEveryoneElse = new HashMap<String,String>();
        for (Map.Entry<String,String> entry: dialectConverterForWisconsinites.entrySet()) {
            dialectConverterForEveryoneElse.put(entry.getValue(), entry.getKey());
        }

        assertNotNull(dialectConverterForEveryoneElse.get("brat"));
    }
}
