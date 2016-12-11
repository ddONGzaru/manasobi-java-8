package io.manasob.ex.util;

import com.google.common.io.BaseEncoding;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-09.
 */
public class Decode_base64_string {

    final private String encodedPhrase = "TGVhcm4uIEVhdC4gQ29kZS4=";

    // Java 8
    @Test
    public void string_base64_decode_java_8() throws UnsupportedEncodingException {

        byte[] decodedPhraseAsBytes = java.util.Base64.getDecoder().decode(encodedPhrase);

        String phraseDecodedToString = new String(decodedPhraseAsBytes, "utf-8");

        assertEquals("Learn. Eat. Code.", phraseDecodedToString);
    }

    // Google Guava
    @Test
    public void string_base64_decode_guava() throws UnsupportedEncodingException {

        byte[] decodedPhraseAsBytes = BaseEncoding.base64().decode(encodedPhrase);

        String phraseDecodedToString = new String(decodedPhraseAsBytes, "utf-8");

        assertEquals("Learn. Eat. Code.", phraseDecodedToString);
    }


}
