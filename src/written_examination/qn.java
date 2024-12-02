package written_examination;

import java.util.Arrays;
import java.util.Scanner;

public class qn {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        // 自定义比较器
        Arrays.sort(nums, (a, b) -> {
            return (a.toString() + b.toString()).compareTo(b.toString() + a.toString());
        });

        for (int x : nums) {
            System.out.print(x + " ");
        }
    }

}
