package exam;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class kdxf {
    /**
     * 每次将l-1 到 r - 1下标的元素移到数组最后，一共m次操作
     * 统计每个数字出现的下标数
     */
    public static void test1() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // 数组长度
        int m = in.nextInt();  // 操作次数

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int[][] sets = new int[n][n];
        int[] res = new int[n];
        for (int j = 0; j < n; j++) {
            sets[arr[j] - 1][j] = 1;
            res[arr[j] - 1]++;
        }
        for (int i = 0; i < m; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            int[] temp = Arrays.copyOfRange(arr, l - 1, r);
            System.arraycopy(arr, r, arr, l - 1, n - r);
            System.arraycopy(temp, 0, arr, n - (r - l + 1), r - l + 1);
            for (int j = l - 1; j < n; j++) {
                if (sets[arr[j] - 1][j] != 1) {
                    res[arr[j] - 1]++;
                    sets[arr[j] - 1][j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
