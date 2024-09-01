package exam.ali;

import java.util.*;

/**
 * @author fyy
 * @version 1.0
 * @description
 * @date 2024/8/31 9:40
 */
public class lxhy0831 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "thestoryofleetcodefoobarandmestory";
        String[] words = new String[]{"story","fleet", "bar", "foo"};
//        String str = "Java";
//        String[] words = new String[]{"Java"};
        int[][] res = indexPairs(str, words);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }

    }
    public static int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        for (String word : words) {
            int cur = 0;
            while (text.indexOf(word, cur) != -1) {
                int start = text.indexOf(word, cur);
                cur++;
                int[] temp = new int[]{start, start + word.length() - 1};
                list.add(temp);
            }
        }
        list.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            res[i] = ints;
        }
        return res;
    }
}
