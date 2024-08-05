package leetcode.checklist.Hot100;

import java.util.*;

public class hot100 {

    // 1. 两数之和
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]).intValue(), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    // 49. 字母异位词分组
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        List<int[]> temp = new ArrayList<>();
        for (String str : strs) {
            int[] dic = getDic(str);
            int j = 0;
            for (; j < temp.size(); j++) {
                if (compare(temp.get(j), dic)) {
                    ans.get(j).add(str);
                    break;
                }
            }
            if (j == temp.size()) {
                List<String> list = new ArrayList<>();
                list.add(str);
                ans.add(list);
                temp.add(dic);
            }
        }
        return ans;
    }

    private int[] getDic(String str) {
        int[] dic = new int[26];
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            dic[c - 'a']++;
        }
        return dic;
    }

    private boolean compare(int[] dic1, int[] dic2) {
        for (int i = 0; i < dic1.length; i++) {
            if (dic1[i] != dic2[i]) {
                return false;
            }
        }
        return true;
    }

    // 128. 最长连续序列 todo dp 并查集
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int mx = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int cnt = 1;
                int temp = num;
                while (set.contains(++temp)) {
                    cnt++;
                }
                mx = Math.max(cnt, mx);
            }
        }
        return mx;
    }

    // 283. 移动零 todo 1
    public void moveZeroes(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt++;
            } else if (cnt > 0){
                nums[i - cnt] = nums[i];
            }
        }
        for (int i = nums.length - cnt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 11. 盛最多水的容器
    public int maxArea(int[] height) {
        int mx = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            mx = Math.max(area, mx);
            if (height[left] < height[right]) {
                int temp = height[left];
                while (left < right && height[left] <= temp) {
                    left++;
                }
            } else {
                int temp = height[right];
                while (right > left && height[right] <= temp) {
                    right--;
                }
            }
        }
        return mx;
    }

    // 15. 三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    // 42. 接雨水 todo 双指针 单调栈
    public int trap(int[] height) {
        int sum = 0;
        int[] pre = new int[height.length + 1];
        int[] end = new int[height.length + 1];
        for (int i = 0; i < height.length; i++) {
            pre[i + 1] = Math.max(pre[i], height[i]);
        }
        for (int i = height.length - 1; i >= 0; i--) {
            end[i] = Math.max(end[i + 1], height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            sum += Math.max(0, Math.min(pre[i + 1], end[i]) - height[i]);
        }
        return sum;
    }
}
