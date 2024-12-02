package util;

public class equalsTest {
    public static void main(String[] args) {
        Integer integer = 1299;
        Integer integer2 = 1299;
        System.out.println(integer.equals(integer2));       // true
        System.out.println(integer == integer2);       // true
        float f = 123456789.123456f;
        System.out.println(f);                          //1.23456792E8  只能保留6位精度
    }
}
