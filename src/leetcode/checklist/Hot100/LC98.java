package leetcode.checklist.Hot100;

import leetcode.common.TreeNode;

public class LC98 {
   /* public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long minValue, long maxValue, ) {
        if (root == null) {
            return true;
        }
        if (root.val < minValue || root.val > maxValue) {
            return false;
        }
        return dfs(root.left, minValue, root.val) && dfs(root.right, root.val, maxValue);
    }*/

    /*private long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left) || root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
   }*/

    public boolean isValidBST(TreeNode root) {
        long[] ans = dfs(root);
        return ans[1] != Long.MAX_VALUE;
    }

    private long[] dfs(TreeNode root) {
        if (root == null) {
            return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        }
        long[] left = dfs(root.left);
        long[] right = dfs(root.right);
        if (root.val <= left[1] || root.val >= right[0]) {
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        }
        return new long[]{Math.min(left[0], root.val), Math.max(right[1], root.val)};
    }
}
