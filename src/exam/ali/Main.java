package exam.ali;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author fyy
 * @version 1.0
 * @description
 * @date 2024/8/24 19:00
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        int[] temp = new int[n];
        for (int i = 1; i < n; i++) {
            long x1 = arr1[i] - arr1[i - 1];
            long x2 = arr2[i] - arr2[i - 1];
            if (x1 == x2) {
                temp[i] = 1;
            }
        }
        int ans = 0;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (temp[i] == 1) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 0;
            }
        }
        System.out.println(ans + 1);
    }
}
