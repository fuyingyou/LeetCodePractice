package leetcode.common;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) {
        String str = "(#PointD)%20%20%3E%20(#last_PointD)";
        String encodedString = "Hello%2C+World%21";
        try {
            String decodedString = URLDecoder.decode(str, StandardCharsets.UTF_8.toString());
            System.out.println(decodedString);
        } catch (UnsupportedEncodingException e) {
            // 处理异常
        }
    }


}
