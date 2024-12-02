package leetcode.dmsxl.backtracking;

import java.util.*;

/**
 * @author fyy
 * @version 1.0
 * @description
 * @date 2024/8/30 13:23
 */
public class BackTracking {
    /* 77. 组合
    给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
    示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]*/

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(1, n, k, path, ans);
        return ans;
    }

    private void dfs(int i, int n, int k, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 已有path.size()个，共需k个，仍需k - path.size()个，因此，j加后面 不能小于k-path.size()个
        for (int j = i; j <= n - (k - path.size()) + 1; j++) {
            path.add(j);
            dfs(j + 1, n, k, path, ans);
            path.remove(path.size() - 1);
        }
    }

    /* 77.组合优化
    找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
    说明：

    所有数字都是正整数。
    解集不能包含重复的组合。
    示例 1: 输入: k = 3, n = 7 输出: [[1,2,4]]
    示例 2: 输入: k = 3, n = 9 输出: [[1,2,6], [1,3,5], [2,3,4]]*/
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs1(1, n, 0, k, path, ans);
        return ans;
    }

    void dfs1(int idx, int n, int sum, int k, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == k) {
            if (sum == n) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = idx; i <= 9; i++) {
            path.add(i);
            dfs1(i + 1, n, sum + i, k, path, ans);
            path.remove(path.size() - 1);
        }
    }

    /*17.电话号码的字母组合
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。*/
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return ans;
        }
        List<Character> path = new ArrayList<>();
        String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs2(ans, path, strs, digits, 0);
        return ans;
    }

    private void dfs2(List<String> ans, List<Character> path, String[] strs, String digits, int idx) {
        if (path.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (char ch : path) {
                sb.append(ch);
            }
            ans.add(sb.toString());
            return;
        }
        if (idx > digits.length()) {
            return;
        }
        char[] charArray = strs[digits.charAt(idx) - '0'].toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            path.add(charArray[i]);
            dfs2(ans, path, strs, digits, idx + 1);
            path.remove(path.size() - 1);
        }
    }

    // 39. 组合总和
    //给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //candidates 中的数字可以无限制重复被选取。
    //说明：
    //所有数字（包括 target）都是正整数。
    //解集不能包含重复的组合。

    //示例 1：
    //输入：candidates = [2,3,6,7], target = 7,
    //所求解集为： [ [7], [2,2,3] ]

    //示例 2：
    //输入：candidates = [2,3,5], target = 8,
    //所求解集为： [ [2,2,2,2], [2,3,3], [3,5] ]
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs3(ans, path, target, candidates, 0);
        return ans;
    }

    private void dfs3(List<List<Integer>> ans, List<Integer> path, int target, int[] candidates, int idx) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
        }
        if (target < 0 || idx >= candidates.length) {
            return;
        }
        if (target < candidates[idx]) {
            return;
        }
        dfs3(ans, path, target, candidates, idx + 1);
        path.add(candidates[idx]);
        dfs3(ans, path, target - candidates[idx], candidates, idx);
        path.remove(path.size() - 1);
    }

    // 组合数2
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs4(candidates, 0, target, path, res);
        return res;
    }

    private void dfs4(int[] candidates, int startIndex, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }
        if (startIndex == candidates.length) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                return;
            }
            if (candidates[i] > target) {
                return;
            }
            path.add(candidates[i]);
            dfs4(candidates, i + 1, target - candidates[i], path, res);
            path.remove(path.size() - 1);
        }
    }

    // 分割子字符串
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backTracking(res, s, path, 0);
        return res;
    }

    private void backTracking(List<List<String>> res, String s, List<String> path, int idx) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(path));
        }
        for (int j = idx; j < s.length(); j++) {
            if (isHuiWen(s, idx, j)) {
                path.add(s.substring(idx, j + 1));
                backTracking(res, s, path, j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isHuiWen(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backTracking2(res, path, s, 3, 0);
        return res;
    }

    private void backTracking2(List<String> res, List<String> path, String s, int num, int idx) {
        if (num == 0) {
            if (idx < s.length() - 1 && s.charAt(idx) == '0' || idx == s.length()) {
                return;
            }
            String temp = s.substring(idx);
            if (temp.length() > 3 || Integer.parseInt(temp) > 255) {
                return;
            }
            StringBuilder sb = new StringBuilder(path.get(0));
            for (int i = 1; i < path.size(); i++) {
                sb.append(".").append(path.get(i));
            }
            sb.append(".").append(temp);
            res.add(sb.toString());
            return;
        }

        for (int i = idx + 1; i <= Math.min(idx + 3, s.length()); i++) {
            if (i > idx + 1 && s.charAt(idx) == '0') {
                break;
            }
            String temp = s.substring(idx, i);
            if (Integer.parseInt(temp) > 255) {
                break;
            }
            path.add(temp);
            backTracking2(res, path, s, num - 1, i);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs5(res, path, nums, 0);
        return res;
    }

    private void dfs5(List<List<Integer>> res, List<Integer> path, int[] nums, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        dfs5(res, path, nums, idx + 1);
        path.add(nums[idx]);
        dfs5(res, path, nums, idx + 1);
        path.remove(path.size() - 1);
    }

    // 非递减子序列
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTracking3(res, path, nums, 0);
        return res;
    }

    private void backTracking3(List<List<Integer>> res, List<Integer> path, int[] nums, int idx) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                backTracking3(res, path, nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] onPath = new boolean[nums.length];
        dfs6(res, path, nums, 0, onPath);
        return res;
    }

    private void dfs6(List<List<Integer>> res, List<Integer> path, int[] nums, int idx, boolean[] onPath) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if (!onPath[i]) {
                path.add(nums[i]);
                onPath[i] = true;
                dfs6(res, path, nums, idx + 1, onPath);
                path.remove(path.size() - 1);
                onPath[i] = false;
            }
        }
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] onPath = new boolean[tickets.size()];
        backtrack(res, path, onPath, tickets, 0);
        return res;
    }

    private void backtrack(List<String> res, List<Integer> path, boolean[] onPath, List<List<String>> tickets, int idx) {
        if (idx == tickets.size()) {
//            StringBuilder
            return;
        }


    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] onPath = new boolean[n];
        boolean[] used1 = new boolean[2 * n];
        boolean[] used2 = new boolean[2 * n];
        dfs(res, path, used1, used2, onPath,0);
        return res;
    }

    private void dfs(List<List<String>> res, List<Integer> path, boolean[] used1, boolean[] used2, boolean[] onPath, int idx) {
        int n = used2.length / 2;
        if (idx == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < path.get(i); j++) {
                    sb.append(".");
                }
                sb.append("Q");
                for (int j = path.get(i) + 1; j < n; j++) {
                    sb.append(".");
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (used1[idx - j + n] || used2[idx + j] || onPath[j]) {
                continue;
            }
            used1[idx - j + n] = true;
            used2[idx + j] = true;
            onPath[j] = true;
            path.add(j);
            dfs(res, path, used1, used2, onPath, idx + 1);
            used1[idx - j + n] = false;
            used2[idx + j] = false;
            onPath[j] = false;
            path.remove(path.size() - 1);
        }
    }


}
