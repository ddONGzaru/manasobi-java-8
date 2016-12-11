package io.manasob.ex.util;

import com.google.common.io.BaseEncoding;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

/**
 * Created by tw.jang on 2016-12-09.
 */
public class Decode_base64_url {

    final private String encodedURL = "aHR0cDovL2xldmVsdXBsdW5jaC5jb20vZXhhbXBsZXMvP3Bhcm09VGhpcyBwYXJhbWV0ZXI=";

    // Java 8
    @Test
    public void string_base64_decode_java_8()throws UnsupportedEncodingException {

        byte[] decodedURLAsBytes = java.util.Base64.getDecoder().decode(encodedURL);

        String decodedURL = new String(decodedURLAsBytes, "utf-8");

        assertEquals("http://leveluplunch.com/examples/?parm=This parameter", decodedURL);
    }

    // Google Guava
    @Test
    public void string_base64_decode_apache() throws UnsupportedEncodingException {

        byte[] decodedURLAsBytes = BaseEncoding.base64().decode(encodedURL);

        String decodedURL = new String(decodedURLAsBytes, "utf-8");

        assertEquals("http://leveluplunch.com/examples/?parm=This parameter", decodedURL);
    }

}
