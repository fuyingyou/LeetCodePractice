package written_examination;

import java.util.Scanner;

public class mi {

    public static void t1(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int m = in.nextInt();
            int n = in.nextInt();
            int c = in.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = in.nextInt();
            }
            if (backTrack(m, c, nums, 0)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean backTrack(int capacity, int c, int[] nums, int idx) {
        if (capacity < 0) {
            return false;
        }
        if (capacity == 0 || capacity <= c) {
            return true;
        }
        if (idx == nums.length) {
            return capacity < c;
        }
        return backTrack(capacity, c, nums, idx + 1) || backTrack(capacity - nums[idx], c, nums, idx + 1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                b[j] = in.nextInt();
            }
            int mx = Integer.MAX_VALUE;
            int mn = Integer.MIN_VALUE;
            boolean up = true;
            boolean down = true;
            for (int j = 0; j < n; j++) {
                int mn_num = Math.min(a[j], b[j]);
                int mx_num = Math.max(a[j], b[j]);
                // 递增
                if (mx_num >= mn) {
                    if (mn_num >= mn) {
                        mn = mn_num;
                    } else {
                        mn = mx_num;
                    }
                } else {
                    up = false;
                }
                if (mn_num <= mx) {
                    if (mx_num <= mx) {
                        mx = mx_num;
                    } else {
                        mx = mn_num;
                    }
                } else {
                    down = false;
                }
            }
            if (up || down) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
