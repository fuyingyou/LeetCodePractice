package written_examination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class wy {
//    public static void test3(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextLine()) {
//            String str = in.nextLine();
//            int left = 0, right = 0, level = 0, cnt = 0, i = 0;;
//            int len = str.length();
//            char[] charArray = str.toCharArray();
//            boolean flag = false;
//            boolean pre = false;
//            for ( ; i < len; i++) {
//                if (charArray[i] == '[') {
//                    left++;
//                    level++;
//                    if (level > 5 || (i > 0 && charArray[i - 1] != ',')) {
//                        break;
//                    }
//                    pre = true;
//                    cnt = 0;
//                } else if (charArray[i] == ']') {
//                    right++;
//                    level--;
//                    if (right == left) {
//                        flag = true;
//                        break;
//                    }
//                    pre = true;
//                    cnt = 0;
//                } else if (charArray[i] == ',') {
//                    if (cnt == 0 && (i > 0 && charArray[i - 1] != ']')) {
//                        break;
//                    }
//                    cnt = 0;
//                } else if (charArray[i] != ' '){
//                    cnt++;
//                }
//            }
//            if (flag) {
//                System.out.println("valid");
//            } else {
//                System.out.println("invalid " + i);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int m = in.nextInt();
//        int n = in.nextInt();
//        for (int i = 0; i < m; i++) {
//            String str = in.next();
//            for (int j = 0; j < n; j++) {
//
//            }
//        }
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        long n = scanner.nextLong();
//        long k = scanner.nextLong();
//        int w = scanner.nextInt();
//        scanner.close();
//
//        BigInteger mod = BigInteger.TEN.pow(w);
//        BigInteger base = BigInteger.valueOf(n).mod(mod);
//        BigInteger exponent = BigInteger.valueOf(k);
//
//        BigInteger result = modPow(base, exponent, mod);
//
//        String output = result.toString();
//        while (output.length() < w) {
//            output = "0" + output;
//        }
//        System.out.println(output);
//    }
//
//    // 自定义的快速幂函数，不使用BigInteger自带的modPow
//    public static BigInteger modPow(BigInteger base, BigInteger exponent, BigInteger modulus) {
//        BigInteger result = BigInteger.ONE;
//        base = base.mod(modulus); // 防止base过大
//
//        while (exponent.compareTo(BigInteger.ZERO) > 0) {
//            if (exponent.testBit(0)) { // 判断指数是否为奇数
//                result = result.multiply(base).mod(modulus);
//            }
//            base = base.multiply(base).mod(modulus); // base自乘
//            exponent = exponent.shiftRight(1); // 指数右移一位，相当于除以2
//        }
//        return result;
//    }

    static int n, k;
    static String instructions;
    static boolean[] visited;

    // 定义区间类
    static class Interval implements Comparable<Interval> {
        int start, end;

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        public int compareTo(Interval o) {
            return this.start - o.start;
        }
    }

    // 合并区间函数
    static List<Interval> mergeIntervals(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        Collections.sort(intervals);
        List<Interval> merged = new ArrayList<>();
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (prev.end >= curr.start - 1) { // 重叠或相邻的区间
                prev.end = Math.max(prev.end, curr.end);
            } else {
                merged.add(prev);
                prev = curr;
            }
        }
        merged.add(prev);
        return merged;
    }

    // 标记经过的点
    static void markVisited(List<Interval> intervals) {
        for (Interval interval : intervals) {
            for (int i = interval.start; i <= interval.end; i++) {
                visited[i] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split("\\s+");
        n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);
        instructions = br.readLine();

        visited = new boolean[n + 1]; // 1-based索引
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(k, k));
        visited[k] = true;

        for (char instr : instructions.toCharArray()) {
            List<Interval> newIntervals = new ArrayList<>();
            for (Interval interval : intervals) {
                if (instr == 'L') {
                    int newStart = interval.start == 1 ? 1 : interval.start - 1;
                    int newEnd = interval.end == 1 ? 1 : interval.end - 1;
                    newIntervals.add(new Interval(newStart, newEnd));
                } else if (instr == 'R') {
                    int newStart = interval.start == n ? n : interval.start + 1;
                    int newEnd = interval.end == n ? n : interval.end + 1;
                    newIntervals.add(new Interval(newStart, newEnd));
                } else if (instr == '?') {
                    // 'L'移动
                    int lStart = interval.start == 1 ? 1 : interval.start - 1;
                    int lEnd = interval.end == 1 ? 1 : interval.end - 1;
                    newIntervals.add(new Interval(lStart, lEnd));
                    // 'R'移动
                    int rStart = interval.start == n ? n : interval.start + 1;
                    int rEnd = interval.end == n ? n : interval.end + 1;
                    newIntervals.add(new Interval(rStart, rEnd));
                }
            }
            // 合并区间
            intervals = mergeIntervals(newIntervals);
            // 标记经过的位置
            markVisited(intervals);
        }

        // 构建输出字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(visited[i] ? '1' : '0');
        }
        System.out.println(sb.toString());
    }
}
