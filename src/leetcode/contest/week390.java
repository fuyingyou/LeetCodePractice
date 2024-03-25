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

    public long[] mostFrequentIDs1(int[] nums, int[] freq) {
        HashMap<Integer, Long> map = new HashMap<>();
        TreeMap<Long, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        int n = nums.length;
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            long pre = map.getOrDefault(nums[i], 0L);
            long cur = pre + freq[i];
            if (cur == 0) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], cur);
            }

            if (treeMap.containsKey(pre)) {
                int val = treeMap.get(pre);
                if (val == 1) {
                    treeMap.remove(pre);
                } else {
                    treeMap.put(pre, val - 1);
                }
            }
            treeMap.put(cur, treeMap.getOrDefault(cur, 0) + 1);
            ans[i] = treeMap.firstKey();
        }
        return ans;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Node root = new Node();
        int n = wordsContainer.length;

        // 构建字典树
        for (int i = 0; i < n; i++) {
            Node cur = root;
            int len = wordsContainer[i].length();
            if (len < cur.minL) {
                cur.minL = len;
                cur.i = i;
            }
            char[] charArray = wordsContainer[i].toCharArray();
            for (int j = len - 1; j >= 0; j--) {
                int x = charArray[j] - 'a';
                if (cur.son[x] == null) {
                    cur.son[x] = new Node();
                }
                cur = cur.son[x];
                if (len < cur.minL)  {
                    cur.minL = len;
                    cur.i = i;
                }
            }
        }
        int m = wordsQuery.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            Node cur = root;
            int l = wordsQuery[i].length();
            char[] charArray = wordsQuery[i].toCharArray();
            for (int j = l - 1; j >= 0; j--) {
                if (cur.son[charArray[j] - 'a'] != null) {
                    cur = cur.son[charArray[j] - 'a'];
                } else {
                    break;
                }
            }
            ans[i] = cur.i;
        }
        return ans;
    }
}

// 字典树节点
class Node{
    Node[] son = new Node[26];
    int minL = Integer.MAX_VALUE;
    int i;
}
