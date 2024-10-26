package exam;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] colors = new char[n + 1];
        String str = in.next();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < n; i++) {
            colors[i + 1] = charArray[i];
        }
        int[] du = new int[n + 1];
        int[] cnt = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 'B') {
                cnt[i] = 1;
            }
        }
        HashMap<Integer, Integer> son2Parent = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            du[start]++;
            son2Parent.put(end, start);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (du[i] == 0) {
                deque.add(i);
            }
        }
        while (!deque.isEmpty()) {
            int son = deque.pollFirst();
            System.out.println(son);
            if (!son2Parent.containsKey(son)) {
                break;
            }
            int parent = son2Parent.get(son);
            du[parent]--;
            if (charArray[parent] == 'B') {
                cnt[parent] = cnt[son] + 1;
            } else {
                cnt[parent] = cnt[son];
            }
            if (du[parent] == 0) {
                deque.addFirst(parent);
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(cnt[i] + " ");
        }
        System.out.println();
        int mn = n;
        int yezi = 0;
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 'R') {
                mn = Math.min(mn, cnt[i]);
                yezi = i;
            }
        }
        while (son2Parent.containsKey(yezi)) {
            int par = son2Parent.get(yezi);
            cnt[par] -= mn;
            yezi = par;
        }
        int mx = 0;
        for (int i = 1; i < n; i++) {
            mx = Math.max(mx, cnt[i]);
        }
        System.out.println(mx);
    }
}

//public class Main {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] category = new int[n];
//        int[] move = new int[n];
//        for (int i = 0; i < n; i++) {
//            category[i] = in.nextInt();
//        }
//        int[] sum = new int[3];
//        for (int i = 0; i < n; i++) {
//            move[i] = in.nextInt();
//            sum[category[i]] += move[i];
//        }
//        int left = 0, right = 0;
//        int sum1 = 0, sum2 = 0;
//        while (right < n) {
//            if (category[right] == 2) {
//
//            }
//        }
//
//        int cnt = 0;
//        for (int i = 1; i < n; i++) {
//            if (category[i] != category[i - 1]) {
//                cnt++;
//            }
//        }
//        System.out.println(cnt);
//    }
//}


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = in.nextInt();
//        }
//        int[] pre = new int[n];
//        pre[0] = 1;
//        int[] end = new int[n];
//        end[n - 1] = 1;
//        for (int i = 1; i < n; i++) {
//            if (nums[i] > nums[i - 1]) {
//                pre[i] = pre[i - 1] + 1;
//            } else {
//                pre[i] = 1;
//            }
//        }
//        for (int j = n - 2; j >= 0; j--) {
//            if (nums[j] > nums[j + 1]) {
//                end[j] = end[j + 1] + 1;
//            } else {
//                end[j] = 1;
//            }
//        }
//        int mx = 0;
//        for (int i = 0; i < n; i++) {
//            mx = Math.max(pre[i] + end[i] - 1, mx);
//        }
//        System.out.println(mx);
//    }