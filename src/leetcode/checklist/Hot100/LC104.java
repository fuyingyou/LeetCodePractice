package leetcode.checklist.Hot100;

import leetcode.common.TreeNode;

public class LC104 {

    /*int ans = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return ans;
        }
        dfs(root, 1);
        return ans;
    }

    void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        ans = Math.max(ans, depth);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }*/

   /* public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 1;
        Deque<DepthNode> deque = new LinkedList<>();
        deque.add(new DepthNode(root, 1));
        while (!deque.isEmpty()) {
            DepthNode depthNode = deque.pollLast();
            ans = Math.max(ans, depthNode.depth);
            if (depthNode.treeNode.left != null) {
                deque.addLast(new DepthNode(depthNode.treeNode.left, depthNode.depth + 1));
            }
            if (depthNode.treeNode.right != null) {
                deque.addLast(new DepthNode(depthNode.treeNode.right, depthNode.depth + 1));
            }
        }
        return ans;
    }*/
   public int maxDepth(TreeNode root) {
       return dfs(root);
   }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepthLeft = dfs(root.left);
        int maxDepthRight = dfs(root.right);
        return Math.max(maxDepthLeft, maxDepthRight) + 1;
    }
}

class DepthNode {
    TreeNode treeNode;
    int depth;

    public DepthNode(TreeNode treeNode, int depth) {
        this.treeNode = treeNode;
        this.depth = depth;
    }
}

