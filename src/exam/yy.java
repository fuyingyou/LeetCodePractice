package exam;

import java.util.Arrays;
import java.util.Scanner;

public class yy {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        String[] strs = str.split(" ");
//        int n = strs.length;
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = Integer.parseInt(strs[i]);
//        }
//        int right = 0;
//        for (int i = 0; i < Math.min(n, right + 1); i++) {
//            if (nums[i] > 0) {
//                right = Math.max(right, i + nums[i]);
//            }
//        }
//        System.out.println(right >= n - 1);
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int target = in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//        }
//        Arrays.sort(nums);
//        int res = 0;
//        for (int i = 0; i < n - 2; i++) {
//            int left = i + 1;
//            int right = n - 1;
//            while (left < right) {
//                if (nums[i] + nums[left] + nums[right] == target) {
//                    res++;
//                    left++;
//                    right--;
//                } else if (nums[i] + nums[left] + nums[right] > target) {
//                    right--;
//                } else {
//                    left++;
//                }
//            }
//        }
//        System.out.println(res);
//    }
//    public int goldenFinger (int n, int m) {
//        int res = 0;
//        while (n > 1 && m > 1) {
//            if (n < m) {
//                int temp = n;
//                n = m;
//                m = temp;
//            }
//            int a = n - m;
//            n = m;
//            m = a;
//            res++;
//        }
//        if (n == 1 || m == 1) {
//            res += n == 1 ? m : n;
//        }
//        return res;
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[][] arr = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                arr[i][j] = in.nextInt();
//            }
//        }
//        int k = in.nextInt();
//        int[][] nums = new int[n][k];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < k; j++) {
//                nums[i][j] = in.nextInt();
//            }
//        }
//        boolean[] path = new boolean[k];
//        int mx = 0;
//        for (int start = 0; start < n; start++) {
//            path[start] = true;
//            mx = Math.max(mx, backTracking(arr, nums, path, 1, start) + nums[start][0]);
//            path[start] = false;
//        }
//        // level 表示第n周
//        // idx 表示项目
//        System.out.println(mx);
//    }
//
//    private static int backTracking(int[][] arr, int[][] nums, boolean[] path, int level, int start) {
//        int n = nums.length;
//        int k = nums[0].length;
//        if (level == k) {
//            return 0;
//        }
//        int mx = 0;
//        // i表示其余项目
//        for (int end = 0; end < n; end++) {
//            if (arr[start][end] == 1 && !path[end]) {
////                System.out.println("当前level: " + level + ", 当前val: " + nums[end][level]);
//                path[end] = true;
//                int temp = backTracking(arr, nums, path, level + 1, end) + nums[end][level];
////                System.out.println("当前temp " + temp);
//                mx = Math.max(mx, temp);
//                path[end] = false;
//            }
//        }
//        return mx;
//    }
}
