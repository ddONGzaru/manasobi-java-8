package io.manasob.ex.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by tw.jang on 2016-12-08.
 */
@Slf4j
public class Stream_find_and_match {

    @Data
    @AllArgsConstructor
    class HiddenObjectGame {

        String name = null;
        double rating;
        double totalPlays;
        LocalDate releaseDate;
    }

    List<HiddenObjectGame> games;

    @Before
    public void setUp() {

        games = new ArrayList<>();

        games.add(new HiddenObjectGame("The Daily SNOOP",                 4.65, 22207, LocalDate.of(2011, Month.MARCH,    15)));
        games.add(new HiddenObjectGame("Gardenscapes",                    4.43,  1670, LocalDate.of(2009, Month.DECEMBER, 29)));
        games.add(new HiddenObjectGame("Barn Yarn",                       4.55,  1453, LocalDate.of(2013, Month.JUNE,     18)));
        games.add(new HiddenObjectGame("The Treasures of Mystery Island", 4.09,   594, LocalDate.of(2009, Month.JUNE,     29)));
        games.add(new HiddenObjectGame("Paparazzi",                       3.74,   391, LocalDate.of(2006, Month.OCTOBER,  10)));
    }

    // allMatch
    @Test
    public void stream_allMatch() {

        boolean containVowel = games.stream()
                                    .allMatch(game -> game.getName().contains("a"));
        assertTrue(containVowel);
    }

    // anyMatch
    @Test
    public void stream_anyMatch() {

        boolean playsGt1000 = games.stream()
                                   .anyMatch(game -> game.getTotalPlays() > 1000);
        assertTrue(playsGt1000);
    }

    // noneMatch
    @Test
    public void stream_noneMatch() {

        Predicate<HiddenObjectGame> playsGt1000 = p -> p.getTotalPlays() > 1000;
        Predicate<HiddenObjectGame> ratingGt5 = p -> p.getRating() > 5;

        boolean noneMatch = games.stream()
                                 .noneMatch(ratingGt5.and(playsGt1000));

        assertTrue(noneMatch);
    }

    // findFirst
    @Test
    public void stream_findFirst() {

        Optional<HiddenObjectGame> firstHiddenGame = games.stream().findFirst();

        assertTrue(firstHiddenGame.isPresent());
        assertEquals("The Daily SNOOP", firstHiddenGame.get().getName());
    }

    // findAny
    @Test
    public void stream_findAny() {

        Predicate<HiddenObjectGame> releaseDateInApril = p -> Month.APRIL == p.getReleaseDate().getMonth();

        Optional<HiddenObjectGame> hiddenGameReleaseInApril = games.stream()
                                                                   .filter(releaseDateInApril)
                                                                   .findAny();

        assertFalse(hiddenGameReleaseInApril.isPresent());
    }

}
