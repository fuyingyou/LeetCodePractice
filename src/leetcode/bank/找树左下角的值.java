package leetcode.bank;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class 找树左下角的值 {
   /* public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int ans = 0;
        while (!deque.isEmpty()) {
            int n = deque.size();
            ans = deque.peekFirst().val;
            for (int i = 0; i < n; i++) {
                TreeNode node = deque.pollFirst();
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
        }
        return ans;
    }*/

    public int findBottomLeftValue(TreeNode root) {
        TreeNode node = root;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            node = deque.pollFirst();
            if (node.right != null) {
                deque.addLast(node.right);
            }
            if (node.left != null) {
                deque.addLast(node.left);
            }
        }
        return node.val;
    }
}
