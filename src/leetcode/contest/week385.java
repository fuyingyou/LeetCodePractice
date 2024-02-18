package leetcode.contest;

import java.util.*;

public class week385 {
    public int countPrefixSuffixPairs(String[] words) {
        int cnt = 0;
        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    boolean isPrefixAndSuffix(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return false;
        }
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int len1 = charArray1.length;
        int len2 = charArray2.length;
        for (int i = 0; i < len1; i++) {
            if (charArray1[i] != charArray2[i]) {
                return false;
            }
        }
        if (len1 == len2) {
            return true;
        }
        for (int i = 0; i < len1; i++) {
            if (charArray1[i] != charArray2[i + len2 - len1]) {
                return false;
            }
        }
        return true;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int x : arr1) {
            while (x > 0) {
                set.add(x);
                x /= 10;
            }
        }
        for (int y : arr2) {
            while (y > 0) {
                list.add(y);
                y /= 10;
            }
        }
        Collections.sort(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            if (set.contains(list.get(i))) {
                res = f(list.get(i));
                break;
            }
        }
        return res;
    }

    public int pre(int x, int y) {
        int cnt = 0;
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        while (x > 0) {
            deque1.add(x % 10);
            x /= 10;
        }
        while (y > 0) {
            deque2.add(y % 10);
            y /= 10;
        }
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            int i = deque1.pollLast();
            int j = deque2.pollLast();
            if (i == j) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }


    public int f(int x) {
        if (x == 0) {
            return 1;
        }
        int res = 0;
        while (x > 0) {
            x /= 10;
            res++;
        }
        return res;
    }

    public int mostFrequentPrime(int[][] mat) {
        int res = -1;
        int n = mat.length, m = mat[0].length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] path = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 8; k++) {
                    int newX = i, newY = j;
                    int num = mat[newX][newY];
                    while (true) {
                        newX += path[k][0];
                        newY += path[k][1];
                        if (newX < 0 || newY < 0 || newX >= n || newY >= m) {
                            break;
                        }
                        num = num * 10 + mat[newX][newY];
                        if (isPrime(num)) {
                            map.put(num, map.getOrDefault(num, 0) + 1);
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for (int x : map.keySet()) {
            if (map.get(x) > cnt) {
                cnt = map.get(x);
                res = x;
            } else if (map.get(x) == cnt) {
                res = Math.max(res, x);
            }
        }
        return res;
    }

    boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
