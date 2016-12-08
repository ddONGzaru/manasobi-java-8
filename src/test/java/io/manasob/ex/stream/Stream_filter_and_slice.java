package io.manasob.ex.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-08.
 */
@Slf4j
public class Stream_filter_and_slice {

    @Data
    @AllArgsConstructor
    class Post {

        String description;
        String tags;
        int wordlength;
    }

    List<Post> posts;

    @Before
    public void setUp() {

        posts = new ArrayList<>();

        posts.add(new Post("Java 8 is jammed packed with some cool",            "java 8, eclipse",             459));
        posts.add(new Post("The Date-Time package introduced in the Java SE 8", "java 8, date time api",       750));
        posts.add(new Post("Prefer empty collection to null is a basic",        "clean code, java",            245));
        posts.add(new Post("Screencast #1: Intro to filtering collections",     "java, java tutorial, guava", 1234));
        posts.add(new Post("Screencast #2: Intro to transforming objects",      "java, java tutorial",        9483));
    }

    // Filter with predicate
    @Test
    public void filter_with_predicate() {

        List<Post> postWithLessThan500 = posts.stream()
                                              .filter(p -> p.wordlength < 500)
                                              .collect(Collectors.toList());

        assertEquals(2, postWithLessThan500.size());
    }

    // Filter unique elements
    @Test
    public void filter_unique_elements() {

        List<String> tags = posts.stream()
                                 .map(Post::getTags)
                                 .flatMap(tag -> Arrays.stream(tag.split(","))
                                 .map(String::trim)
                                 .map(String::toLowerCase))
                                 //.map(Object::toString)
                                 .distinct()
                                 .collect(Collectors.toList());


        assertThat(tags).contains("java 8", "eclipse", "date time api", "clean code",
                "java", "java tutorial", "guava");

    }

    // Filter and truncate
    @Test
    public void filter_and_truncate() {

        List<Post> firstTwoPosts = posts.stream()
                                        .limit(2)
                                        .collect(Collectors.toList());

        log.info("filter_and_truncate :: {}", firstTwoPosts.toString());

        assertEquals(2, firstTwoPosts.size());
    }

    // Skip elements
    @Test
    public void skipping_elements() {

        List<Post> firstTwoPosts = posts.stream()
                                        .skip(4)
                                        .collect(Collectors.toList());

        log.info("skipping_elements :: {}", firstTwoPosts.toString());

        assertEquals(1, firstTwoPosts.size());
    }
}
