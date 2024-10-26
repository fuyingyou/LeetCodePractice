package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class XiaohongSimplified {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 读取测试用例数量
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            // 读取字符串长度
            int n = Integer.parseInt(sc.nextLine());
            // 读取字符串
            String s = sc.nextLine();
            boolean hasR = false, hasE = false, hasD = false;
            int flag1 = 0, flag2 = 0;
            int flag3 = -1, flag4 = -1;
            // 检查字符串中是否包含 'r'，'e'，'d'
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == 'r') {
                    hasR = true;
                    flag1 = i;
                }
                if (c == 'e') {
                    hasE = true;
                    flag2 = i;
//                    if (flag3 != -1) {
//                        flag3 = i;
//                    }
                } else if (c == 'd') {
                    hasD = true;
//                    if (flag4 != -1) {
//                        flag4 = i;
//                    }
                }
            }
            // 判断是否可以染色完成
            if (hasR && hasE && hasD && s.charAt(0) == 'r' && s.charAt(n - 1) == 'd' && flag1 < flag2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }

}
