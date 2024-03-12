package newcode.mt;

import java.util.*;
import java.util.function.Predicate;

public class Test {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] arr = new int[n][n];
//        int[][] sum = new int[n + 1][n + 1];
//        for (int i = 0; i < n; i++) {
//            String str = sc.next();
//            char[] array = str.toCharArray();
//            for (int j = 0; j < array.length; j++) {
//                arr[i][j] = array[j] - '0';
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + arr[i][j];
//            }
//        }
//
//        for (int k = 1; k <= n; k++) {
//            int cnt = 0;
//            for (int r1 = 0; r1 < n - k + 1; r1++) {
//                for (int c1 = 0; c1 < n - k + 1; c1++) {
//                    if (k * k % 2 == 0 && sum[r1 + k][c1 + k] - sum[r1 + k][c1] - sum[r1][c1 + k] + sum[r1][c1] == k * k  / 2) {
//                        cnt++;
//                    }
//                }
//            }
//            System.out.println(cnt);
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int q = sc.nextInt();
//        long sum = 0;
//        int cnt = 0;
//        for (int i = 0; i < n; i++) {
//            int num = sc.nextInt();
//            if (num == 0) {
//                cnt++;
//            } else {
//                sum += num;
//            }
//        }
//        for (int i = 0; i < q; i++) {
//            int left = sc.nextInt();
//            int right = sc.nextInt();
//            System.out.println((sum + (long) left * cnt) + " " + (sum + (long) right * cnt));
//        }
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        String str = sc.next();
//        char[] charArray = str.toCharArray();
//        int cnt = 0;
//        for (char ch : charArray) {
//            if (ch == 'M' || ch == 'T') {
//                cnt++;
//            }
//        }
//        int temp = Math.min(k, n - cnt);
//        System.out.println(temp + cnt);
//    }
    private static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        int[][] query = new int[q][3];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            g[x - 1].add(y - 1);
            g[y - 1].add(x - 1);
        }
        for (int i = 0; i < q; i++) {
            int op = sc.nextInt();
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (op == 1) {
                g[u - 1].removeIf(new Predicate<Integer>() {
                   @Override
                   public boolean test(Integer integer) {
                       return integer == v - 1;
                   }
                });
                g[v - 1].removeIf(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer == u - 1;
                    }
                });
            }
            query[i] = new int[]{op, u, v};
        }
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int x : g[i]) {
               unionDirect(i, x);
            }
        }
        Deque<String> deque = new ArrayDeque<>();
        for (int i = q - 1; i >= 0; i--) {
            if (query[i][0] == 1) {
                unionDirect(query[i][1] - 1, query[i][2] - 1);
            } else {
                if (find(query[i][1] - 1) == find(query[i][2] - 1)) {
                    deque.addFirst("Yes");
                } else {
                    deque.addFirst("No");
                }
            }
        }
        while (!deque.isEmpty()) {
            System.out.println(deque.pollFirst());
        }
    }

    // 直接查找
    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // 直接求并
    public static void unionDirect(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if(xRoot != yRoot){
            parent[yRoot] = xRoot;
        }
    }

}
