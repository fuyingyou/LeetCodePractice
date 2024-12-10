package leetcode.checklist.Hot100;

import leetcode.common.TreeNode;

public class LC543 {

    private int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLen = dfs(root.left);
        int rightLen = dfs(root.right);
        ans = Math.max(ans, leftLen + rightLen);
        return Math.max(leftLen, rightLen) + 1;
    }
}
