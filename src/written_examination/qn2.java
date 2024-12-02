package written_examination;

import java.util.*;

public class qn2 {
    public static void test1(String[] args) {
        // 读取输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 字符串长度
        int q = sc.nextInt(); // 操作次数
        sc.nextLine(); // 读取换行符
        String s = sc.nextLine(); // 初始字符串
        char[] chars = s.toCharArray(); // 将字符串转换为字符数组
        boolean[] fixed = new boolean[n]; // 记录每个位置是否为固定位
        Arrays.fill(fixed, false); // 初始时所有位置都是流动位

        // 处理每个操作
        for (int i = 0; i < q; i++) {
            int p = sc.nextInt(); // 操作类型
            if (p == 1) {
                int u = sc.nextInt(); // 将第 u 位设为固定位
                fixed[u - 1] = true; // 数组索引从 0 开始
            } else if (p == 2) {
                // 收集所有流动位的位置和字符
                List<Integer> movingIndices = new ArrayList<>();
                List<Character> movingChars = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (!fixed[j]) {
                        movingIndices.add(j);
                        movingChars.add(chars[j]);
                }
            }
            // 将流动位的字符循环右移一格
            if (movingChars.size() > 0) {
                char temp = movingChars.get(movingChars.size() - 1);
                for (int j = movingChars.size() - 1; j >= 1; j--) {
                        movingChars.set(j, movingChars.get(j - 1));
                    }
                    movingChars.set(0, temp);
                }
                // 将更新后的字符放回对应的位置
                for (int j = 0; j < movingIndices.size(); j++) {
                    chars[movingIndices.get(j)] = movingChars.get(j);
                }
            }
        }
        // 输出最终的字符串
        String result = new String(chars);
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 车站数量
        int m = sc.nextInt(); // 最长乘坐时间
        sc.nextLine(); // 读取换行符

        long INF = Long.MAX_VALUE / 2; // 表示不可达的无穷大值

        // 构建邻接矩阵
        long[][] adj = new long[n][n];
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                long val = Long.parseLong(tokens[j]);
                if (val == -1) {
                    adj[i][j] = INF; // 将 -1 转换为无穷大，表示不可达
                } else {
                    adj[i][j] = val;
                }
            }
        }

        // 初始化 dp 数组
        long[][][] dp = new long[m + 1][n][n];

        // dp[0][i][j] 初始化
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[0][i], INF);
            dp[0][i][i] = 0; // 从自身出发，0 分钟到达自身，疲劳值为 0
        }

        // 初始化 dp[1][i][j]，直接使用邻接矩阵的值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[1][i][j] = adj[i][j];
            }
        }

        // 计算 dp[k][i][j]
        for (int k = 2; k <= m; k++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[k][i], INF);
            }
            for (int i = 0; i < n; i++) { // 起点
                for (int l = 0; l < n; l++) { // 中间点
                    if (dp[k - 1][i][l] < INF) {
                        for (int j = 0; j < n; j++) { // 终点
                            if (adj[l][j] < INF) { // l 和 j 相邻
                                long newFatigue = dp[k - 1][i][l] + adj[l][j];
                                if (newFatigue < dp[k][i][j]) {
                                    dp[k][i][j] = newFatigue;
                                }
                            }
                        }
                    }
                }
            }
        }

        // 输出结果
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 1; k <= m; k++) {
                long fatigue = dp[k][i][i];
                if (fatigue >= INF) {
                    sb.append("-1");
                } else {
                    sb.append(fatigue);
                }
                if (k != m) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }

}
