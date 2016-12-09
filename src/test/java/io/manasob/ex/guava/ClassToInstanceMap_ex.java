package io.manasob.ex.guava;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-09.
 */
@Slf4j
public class ClassToInstanceMap_ex {

    @Data
    @AllArgsConstructor
    class Person {
        private String name;
    }

    @Data
    @AllArgsConstructor
    class Jobs {
        private String jobName;
    }

    @Data
    @AllArgsConstructor
    class Address {
        private String streetName;
    }

    @Test
    public void classToINstanceMap_example () {

        Person person = new Person("Jackson");
        Jobs jobs = new Jobs("IT person");
        Address address = new  Address("505 Williams Street");

        ClassToInstanceMap<Object> classToInstanceMap = MutableClassToInstanceMap.create();
        classToInstanceMap.put(Person.class, person);
        classToInstanceMap.put(Jobs.class, jobs);
        classToInstanceMap.put(Address.class, address);

        log.info("classToINstanceMap_example :: {}", classToInstanceMap);

        assertEquals("IT person", classToInstanceMap.getInstance(Jobs.class).getJobName());
    }
}
