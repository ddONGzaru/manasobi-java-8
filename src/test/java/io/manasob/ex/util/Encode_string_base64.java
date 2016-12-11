package io.manasob.ex.util;

import com.google.common.io.BaseEncoding;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-09.
 */
public class Encode_string_base64 {

    // Java 8
    @Test
    public void string_base64_encode_java_8() {

        String randomPhrase = "Learn. Eat. Code.";

        String encodedPhrase = java.util.Base64.getEncoder().encodeToString(randomPhrase.getBytes());

        assertEquals("TGVhcm4uIEVhdC4gQ29kZS4=", encodedPhrase);
    }

    // Google Guava
    @Test
    public void string_base64_encode_guava () {

        String randomPhrase = "Learn. Eat. Code.";

        String encodedPhrase = BaseEncoding.base64().encode(randomPhrase.getBytes());

        assertEquals("TGVhcm4uIEVhdC4gQ29kZS4=", encodedPhrase);
    }

}
