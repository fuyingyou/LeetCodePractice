package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        treeMap.put(1, 2);
//        treeMap.put(4, 2);
//        treeMap.put(3, 2);
//        treeMap.put(2, 2);
//        for (int x : treeMap.keySet()) {
//            System.out.println(x);
//        }
//
//        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
//        linkedHashMap.put(1, 2);
//        linkedHashMap.put(4, 2);
//        linkedHashMap.put(3, 2);
//        linkedHashMap.put(2, 2);
//        for (int x : linkedHashMap.keySet()) {
//            System.out.println(x);
//        }

        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("apple");
        list.add("red");
        list.add("ten");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String str = iterator.next();
//            System.out.println(str);
//        }
        list.forEach(System.out::println);
    }
}
