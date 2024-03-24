package leetcode.contest;

import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class week390 {
    public int maximumLengthSubstring(String s) {
        int[] dic = new int[26];
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int left = 0;
        int mx = 0;
        for (int right = 0; right < n; right++) {
            int idx = charArray[right] - 'a';
            dic[idx]++;
            while (dic[idx] > 2) {
                dic[charArray[left] - 'a']--;
                left++;
            }
            mx = Math.max(mx, right - left + 1);
        }
        return mx;
    }

    public int minOperations(int k) {
        if (k <= 1) {
            return 0;
        }
        int left = 0, right = k;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            int n = mid / 2;
            int m = n;
            if (mid % 2 == 1) {
                m++;
            }
            if ((n + 1) * (m + 1) >= k) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        TreeMap<Long, Integer> count = new TreeMap<>(Collections.reverseOrder());
        count.put(0L, 1000000);

        HashMap<Integer, Long> map = new HashMap<>();

        long[] res = new long[n];

        for(int i = 0; i < n; i++){
            int id = nums[i];
            long before = map.getOrDefault(id, 0L);
            long cur = before + freq[i];

            count.compute(before, (k, v) -> v == 1 ? null : v - 1);
            count.compute(cur, (k, v) -> v == null ? 1 : v + 1);

            map.put(id, cur);

            res[i] = count.firstKey();
        }


        return res;
    }
}
