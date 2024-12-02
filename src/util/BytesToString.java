package util;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class BytesToString {
    public static void main(String[] args) {
        String str = "test";

        // string to byte[] 使用平台默认字符集
        byte[] bytes = str.getBytes();
        for (Byte b :bytes) {
            System.out.print(b + " ");
        }
        System.out.println();
        System.out.println(String.valueOf(bytes));          // [B@404b9385
        System.out.println(Arrays.toString(bytes));         // [116, 101, 115, 116]
        // byte[] to string 使用平台默认字符集
        System.out.println(new String(bytes));              // test

        // string to byte[] 使用平台默认字符集
        byte[] bytes1 = str.getBytes(StandardCharsets.UTF_8);
        for (Byte b :bytes1) {
            System.out.print(b + " ");
        }
        System.out.println();
        // byte[] to string 带编码方式
        System.out.println(new String(bytes1, StandardCharsets.UTF_8));
    }
}
