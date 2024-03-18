package newcode.contest;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        test2();
    }
    public static void test1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = (long) n * (n + 1) >>> 1;
        long num = 1;
        for (int i = 2; i <= n; i++) {
            num = num * i % sum;
        }
        System.out.println(gcd(num, sum));
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            chars[i] = str.toCharArray();
        }
        StringBuffer[][] sbs = new StringBuffer[2][m];
        sbs[0][0] = new StringBuffer();
        sbs[0][0].append(chars[0][0]);
        int now = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sbs[now][j] == null) {
                    sbs[now][j] = new StringBuffer();
                } else {
                    sbs[now][j].setLength(0);
                }
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    sbs[now][j].append(sbs[now][j - 1]);
                } else if (j == 0) {
                    sbs[now][j].append(sbs[now ^ 1][j]);
                } else {
                    String str1 = sbs[now ^ 1][j].toString();
                    String str2 = sbs[now][j - 1].toString();
                    if (str1.compareTo(str2) < 0) {
                        sbs[now][j].append(sbs[now ^ 1][j]);
                    } else  {
                        sbs[now][j].append(sbs[now][j - 1]);
                    }
                }
                sbs[now][j].append(chars[i][j]);
            }
            now = now ^ 1;
        }
        System.out.println(sbs[n - 1][m - 1].toString());
    }

    public final static int mod = 998244353;
    public static void test3() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = sc.nextInt();
            long l1 = 0, l2 = 0, l3 = 0, l4 = 0;
            for (int j = 1; j <= x; j++) {
                l1 = ((long) a * j + b) % mod;
                l2 = (l1 + l2) % mod;
                l3 = (l2 + l3) % mod;
                l4 = (l3 + l4) % mod;
            }
            System.out.println(l1 + " " + l2 + " " + l3 + " " + l4);
        }
    }

}
