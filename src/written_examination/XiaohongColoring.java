package written_examination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class XiaohongColoring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取测试用例数量
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            // 读取字符串长度
            int n = Integer.parseInt(br.readLine());
            // 读取字符串
            String s = br.readLine();
            ArrayList<Integer> R = new ArrayList<>();
            ArrayList<Integer> E = new ArrayList<>();
            ArrayList<Integer> D = new ArrayList<>();
            // 记录字符位置
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == 'r') {
                    R.add(i);
                } else if (c == 'e') {
                    E.add(i);
                } else if (c == 'd') {
                    D.add(i);
                }
            }
            int pr = 0, pe = 0, pd = 0;
            int countRed = 0;
            // 尝试匹配 'red' 子序列
            while (pr < R.size() && pe < E.size() && pd < D.size()) {
                // 找到下一个 e，位置在当前 r 之后
                while (pe < E.size() && E.get(pe) <= R.get(pr)) {
                    pe++;
                }
                if (pe >= E.size()) break;
                // 找到下一个 d，位置在当前 e 之后
                while (pd < D.size() && D.get(pd) <= E.get(pe)) {
                    pd++;
                }
                if (pd >= D.size()) break;
                // 判断是否满足 r < e < d
                if (R.get(pr) < E.get(pe) && E.get(pe) < D.get(pd)) {
                    countRed++;
                    pr++;
                    pe++;
                    pd++;
                } else {
                    pr++;
                }
            }
            // 判断是否可以染色完成
            if (countRed * 3 == n) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

