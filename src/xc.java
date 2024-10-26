import java.sql.SQLOutput;
import java.util.*;

public class xc {
    public static void test1(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            long sum = 0;
            for (int j = 1; j < n; j++) {
                if (k <= 0) {
                    break;
                }
                sum += (long) j * m;
                k--;
            }
            for (int j = 1; j < m; j++) {
                if (k <= 0) {
                    break;
                }
                sum += (long) (n - 1) * m + j;
                k--;
            }
            if (k % 2 == 1) {
                sum += ((k + 1) / 2 * ((long) (n - 1) * m + m - 2)) + (k / 2 * ((long) (n - 1) * m + m - 1));
            } else {
                sum += (long)(k / 2) * (((long) (n - 1) * m + m - 1) + ((long) (n - 1) * m + m - 2));
            }
            System.out.println(sum);
        }
    }


    public static void test2(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        int cnt = 0;
        int left = 0, right = m - 1;
        while (right < n) {
            if (nums[right] - nums[left] <= k) {
                cnt++;
            }
            left++;
            right++;
        }
        System.out.println(n - cnt);
    }

    public static void test3(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int l = in.nextInt();
        int[] a = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            set.add(a[i]);
        }
        int[] nums = new int[set.size()];
        int idx = 0;
        for (Integer integer : set) {
            nums[idx++] = integer;
        }
        Arrays.sort(nums);
        int left = 0, right = n - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (check(a, nums[mid], k, l)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println(nums[left]);
    }
    private static boolean check(int[] a, int num, int k, int l) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < num) {
                i += l - 1;
                k--;
            }
        }
        return k >= 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int p = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[k];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            b[i] = in.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int left = 0, right = Integer.MAX_VALUE;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (check(a, b, p, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(right);
    }

    private static boolean check(int[] a, int[] b, int p, int num) {
        int j = 0;
        int cnt = 0;
        for (int i = 0 ; i < a.length; i++) {
            for ( ; j < b.length; j++) {
                if (Math.abs(a[i] - b[j]) + Math.abs(b[j] - p) <= num) {
                    j++;
                    cnt++;
                    break;
                }
            }
        }
        return cnt == a.length;
    }
}
