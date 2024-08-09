package leetcode.checklist.Hot100;

import leetcode.DFS和BFS.BFS.迷宫中离入口最近的出口;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

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
            } else if (cnt > 0) {
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

    // 3. 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        int[] dic = new int[260];
        char[] charArray = s.toCharArray();
        int mx = 0, left = 0;
        for (int i = 0; i < charArray.length; i++) {
            dic[charArray[i]]++;
            while (dic[charArray[i]] > 1) {
                dic[charArray[left]]--;
                left++;
            }
            mx = Math.max(mx, i - left + 1);
        }
        return mx;
    }

    // 438. 找到字符串中所有字母异位词 todo 1
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = p.toCharArray();
        int[] need = new int[26];
        int[] window = new int[26];
        for (char c : tCharArray) {
            need[c - 'a']++;
        }
        int valid = 0;
        for (int i = 0; i < 26; i++) {
            if (need[i] != 0) {
                valid++;
            }
        }
        int left = 0, right = 0;
        while (right < sCharArray.length) {
            if (need[sCharArray[right] - 'a'] != 0) {
                window[sCharArray[right] - 'a']++;
                if (window[sCharArray[right] - 'a'] == need[sCharArray[right] - 'a']) {
                    valid--;
                }
            }
            right++;
            while (right - left >= p.length()) {
                if (valid == 0) {
                    ans.add(left);
                }
                if (need[sCharArray[left] - 'a'] != 0) {
                    if (window[sCharArray[left] - 'a'] == need[sCharArray[left] - 'a']) {
                        valid++;
                    }
                    window[sCharArray[left] - 'a']--;
                }
                left++;
            }
        }
        return ans;
    }

    // 560. 和为 K 的子数组
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int sum = Arrays.stream(nums).sum();
        int[] pre = new int[nums.length + 1];
        int[] end = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            end[i] = end[i + 1] + nums[i];
        }
        for (int i = 0; i < nums.length + 1; i++) {
            for (int j = i + 1; j < nums.length + 1; j++) {
                if (pre[i] + end[j] == sum - k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // 239. 滑动窗口最大值 todo 1
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            while (i - deque.getFirst() >= k) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return ans;
    }

    // 76. 最小覆盖子串 todo 1
    public String minWindow(String s, String t) {
        String ans = "";
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int[] need = new int[128];
        int[] window = new int[128];
        for (char c : tCharArray) {
            need[c]++;
        }
        int valid = 0;
        for (int i : need) {
            if (i != 0) {
                valid++;
            }
        }
        int left = 0, right = 0;
        while (right < sCharArray.length) {
            if (need[sCharArray[right]] != 0) {
                window[sCharArray[right]]++;
                if (window[sCharArray[right]] == need[sCharArray[right]]) {
                    valid--;
                }
            }
            right++;
            while (valid == 0) {
                if (ans.isEmpty() || ans.length() > right - left) {
                    ans = s.substring(left, right);
                }

                if (need[sCharArray[left]] != 0) {
                    if (window[sCharArray[left]] == need[sCharArray[left]]) {
                        valid++;
                    }
                    window[sCharArray[left]]--;
                }
                left++;
            }
        }
        return ans;
    }


    // 53. 最大子数组和
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int mx = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            mx = Math.max(mx, sum);
        }
        return mx;
    }

    // 56. 合并区间
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if (ans.size() == 0) {
                ans.add(interval);
            } else {
                int temp = ans.get(ans.size() - 1)[1];
                if (temp >= interval[0]) {
                    temp = Math.max(temp, interval[1]);
                    ans.get(ans.size() - 1)[1] = temp;
                } else {
                    ans.add(interval);
                }
            }
        }
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    // 189. 轮转数组
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // 238. 除自身以外数组的乘积
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] pre = new int[n + 1];
        int[] end = new int[n + 1];
        pre[0] = 1;
        end[n] = 1;
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] * nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            end[i] = end[i + 1] * nums[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = pre[i] * end[i + 1];
        }
        return res;
    }

    // 41. 缺失的第一个正数
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 73. 矩阵置零
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // 54. 螺旋矩阵
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        List<Integer> res = new ArrayList<>();
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }

    // 48. 旋转图像
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // 240. 搜索二维矩阵 II
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = 0;
        while (col < n && matrix[row][col] < target) {
            col++;
        }
        if (col == n) {
            col--;
        }
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    // 160. 相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 != null ? p1.next : headB;
            p2 = p2 != null ? p2.next : headA;
        }
        return p1;
    }

    // 206. 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode prev = new ListNode(0);
        prev.next = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev.next;
            prev.next = head;
            head = temp;
        }
        return prev.next;
    }

    // 234. 回文链表
    public boolean isPalindrome(ListNode head) {
        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < (cnt - 1) / 2; i++) {
            cur = cur.next;
        }
        cur.next = reverse(cur.next);
        cur = cur.next;
        ListNode pre = head;
        while (pre != null && cur != null) {
            if (pre.val != cur.val) {
                return false;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 141. 环形链表
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 142. 环形链表 II
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    // 21. 合并两个有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return dummy.next;
    }

    // 2. 两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            int x = l1.val + l2.val + temp;
            cur.next = new ListNode(x % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
            temp = x / 10;
        }
        while (l1 != null) {
            int x = l1.val + temp;
            cur.next = new ListNode(x % 10);
            cur = cur.next;
            l1 = l1.next;
            temp = x / 10;
        }

        while (l2 != null) {
            int x = l2.val + temp;
            cur.next = new ListNode(x % 10);
            cur = cur.next;
            l2 = l2.next;
            temp = x / 10;
        }
        if (temp != 0) {
            cur.next = new ListNode(temp);
        }
        return dummy.next;
    }

    // 19. 删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    // 24. 两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = dummy.next;
        while (cnt >= 2) {
            cnt -= 2;
            for (int i = 0; i < 2; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ListNode next = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = next;
        }

        return dummy.next;
    }

    // 25. K 个一组翻转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy.next;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        ListNode pre = null;
        ListNode cur = dummy.next;
        ListNode p0 = dummy;
        while (cnt >= k) {
            cnt -= k;
            for (int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            ListNode next = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = next;
        }

        return dummy.next;
    }

    // 70. 爬楼梯
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int f1 = 1, f2 = 2, ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = f1 + f2;
            ;
            f1 = f2;
            f2 = ans;
        }
        return ans;
    }

    // 118. 杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i - 1; j++) {
                temp.add(res.get(res.size() - 1).get(j - 1) + res.get(res.size() - 1).get(j));
            }
            if (i > 1) {
                temp.add(1);
            }
            res.add(temp);
        }
        return res;
    }


    // 198. 打家劫舍 todo 1
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 2] = Math.max(dp[i] + nums[i], dp[i + 1]);
        }
        return dp[nums.length + 1];
    }
}
