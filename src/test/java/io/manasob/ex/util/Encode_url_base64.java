package io.manasob.ex.util;

import com.google.common.io.BaseEncoding;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-09.
 */
public class Encode_url_base64 {

    private final String levelUpLunchURL = "http://leveluplunch.com/examples/?parm=This parameter";

    // java 8
    @Test
    public void string_base64_encode_java_8() {

        String encodedURL = java.util.Base64.getEncoder().encodeToString(levelUpLunchURL.getBytes());

        assertEquals("aHR0cDovL2xldmVsdXBsdW5jaC5jb20vZXhhbXBsZXMvP3Bhcm09VGhpcyBwYXJhbWV0ZXI=", encodedURL);
    }

    // Google Guava
    @Test
    public void string_base64_encode_guava() {

        String encodedURL = BaseEncoding.base64Url().encode(levelUpLunchURL.getBytes());

        assertEquals("aHR0cDovL2xldmVsdXBsdW5jaC5jb20vZXhhbXBsZXMvP3Bhcm09VGhpcyBwYXJhbWV0ZXI=", encodedURL);
    }

}
