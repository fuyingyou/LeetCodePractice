package written_examination.nio;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            pre[i + 1] = pre[i] + nums[i];
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            pre[i + 1] = pre[i] + nums[i];
        }
        long sum = 0;
//        for (int i = 1; i < n ; i++) {
//            sum += (long) i * (n - i) * (nums[i] - nums[i - 1]);
//        }

        for (int i = 1; i < n ; i++) {
            sum += (long) i * nums[i] - pre[i];
        }

        System.out.println(sum);
    }
}
