package leetcode.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test981 {
    /**
     * 设计一个基于时间的键值数据结构，该结构可以在不同时间戳存储对应同一个键的多个值，并针对特定时间戳检索键对应的值。
     *
     * 实现 TimeMap 类：
     *
     * TimeMap() 初始化数据结构对象
     * void set(String key, String value, int timestamp) 存储给定时间戳 timestamp 时的键 key 和值 value。
     * String get(String key, int timestamp) 返回一个值，该值在之前调用了 set，
     * 其中 timestamp_prev <= timestamp 。
     * 如果有多个这样的值，它将返回与最大  timestamp_prev 关联的值。
     * 如果没有值，则返回空字符串（""）。
     */

}

class TimeMap {

    private final Map<String, List<String[]>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<String[]>()).add(new String[]{"" + timestamp, value});
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<String[]> strings = map.get(key);
        int idx = binary_search(strings, timestamp);
        return idx < 0 ? "" : strings.get(idx)[1];
    }

    private int binary_search(List<String[]> strings, int timestamp) {
        int left = -1, right = strings.size();
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (Integer.parseInt(strings.get(mid)[0]) <= timestamp) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */