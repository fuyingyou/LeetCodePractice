package leetcode.checklist.Hot100;

import leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (root.right != null) {
                deque.addLast(node.right);
            }
        }

        return root;
    }
}
