package io.manasob.ex.guava;

import com.google.common.base.CharMatcher;
import com.google.common.primitives.Chars;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.*;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-09.
 */
public class CharMatcher_ex {

    // Remove all lowercase letters
    @Test
    public void remove_all_lower_case_from_string () {

        String allButLowerCase = CharMatcher.JAVA_LOWER_CASE
                                            .negate()
                                            .retainFrom("B-double E double R U-N beer run");

        assertEquals("B- E  R U-N  ", allButLowerCase);


        // Java 8 - Stream API
        List<Character> charList = Chars.asList("B-double E double R U-N beer run".toCharArray());

        String result = charList.stream()
                                //.parallel()
                                .filter(c -> !Character.isLowerCase(c))
                                .map(c -> String.valueOf(c))
                                .collect(joining());

        System.out.println(result);

    }

    // Trim leading spaces
    @Test
    public void trim_leading_spaces_from_string () {

        String leftTrimmedString = CharMatcher.WHITESPACE
                                              .trimLeadingFrom("       Some String       ");

        assertEquals("Some String       ", leftTrimmedString);
    }

    // Trim trailing spaces
    @Test
    public void trim_trailing_spaces_from_string () {

        String rightTrimmedString = CharMatcher.WHITESPACE
                                               .trimTrailingFrom("       Some String       ");

        assertEquals("       Some String", rightTrimmedString);
    }

    // Trim all spaces
    @Test
    public void trim_all_spaces_from_string () {

        String trimmedString = CharMatcher.WHITESPACE
                                          .trimFrom("       Some String       ");

        assertEquals("Some String", trimmedString);
    }

    // Remove all * from string
    @Test
    public void remove_all_asterisk_from_string () {

        String stringWithoutAstricks = CharMatcher.is('*')
                                                  .removeFrom("(* This is a comment.  The compiler will ignore it. *)");

        assertEquals("( This is a comment.  The compiler will ignore it. )", stringWithoutAstricks);
    }

    // Validate letter and digit
    @Test
    public void validate_all_charachters_in_string_is_digit_or_letter () {

        boolean randomPharse = CharMatcher.JAVA_LETTER_OR_DIGIT
                                          .matchesAllOf("wefwewef3r343fwdSVD()I#KMFI");

        assertFalse(randomPharse);
    }

    // Grade is passing
    @Test
    public void grade_within_passing_range () {

        boolean failedGrade = CharMatcher.inRange('A', 'C')
                                         .apply('F');

        assertFalse(failedGrade);
    }

    // Obtain digits from telephone number
    @Test
    public void obtain_digits_from_telephone_number () {

        String telephoneNumber = CharMatcher.inRange('0','9')
                                            .retainFrom("123-456-7890");

        assertEquals("1234567890", telephoneNumber);

        // worried about performance
        CharMatcher digits = CharMatcher.inRange('0','9')
                                        .precomputed();

        String teleNumber = digits.retainFrom("123-456-7890");

        assertEquals("1234567890", teleNumber);
    }

    // Count matching chars
    @Test
    public void count_number_of_matching_chars () {

        int numberOfDigits = CharMatcher.DIGIT.countIn("123-LevelUpLunch");

        assertEquals(3, numberOfDigits);
    }

    // Collapse whitespace to dash
    @Test
    public void collapse_whitespace_dash () {

        String address = "505 Williams Street";

        String addressWithDash = CharMatcher.WHITESPACE.collapseFrom(address, '-');

        assertEquals("505-Williams-Street", addressWithDash);
    }

}
