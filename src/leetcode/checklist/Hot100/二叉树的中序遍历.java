package leetcode.checklist.Hot100;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的中序遍历 {

 /*   public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }*/

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<FlagNode> deque = new LinkedList<>();
        deque.addLast(new FlagNode(root, false));
        List<Integer> ans = new ArrayList<>();
        while (!deque.isEmpty()) {
            FlagNode flagNode = deque.pollLast();
            if (flagNode == null) {
                continue;
            }
            if (flagNode.isVisited) {
                ans.add(flagNode.node.val);
            } else {
                if (flagNode.node.right != null) {
                    deque.addLast(new FlagNode(flagNode.node.right, false));
                }
                flagNode.isVisited = true;
                deque.addLast(flagNode);
                if (flagNode.node.left != null) {
                    deque.addLast(new FlagNode(flagNode.node.left, false));
                }
            }
        }
        return ans;
    }
}

class FlagNode {
    TreeNode node;
    boolean isVisited;

    FlagNode(TreeNode node, boolean isVisited) {
        this.node = node;
        this.isVisited = isVisited;
    }
}
