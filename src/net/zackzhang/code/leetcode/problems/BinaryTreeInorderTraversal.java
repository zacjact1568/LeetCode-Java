package net.zackzhang.code.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** 94# 二叉树的中序遍历 */
public class BinaryTreeInorderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> solution(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // s 中不会有 null 元素
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        while (node != null || !s.isEmpty()) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
            node = s.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }

    public static void test() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        System.out.println(new BinaryTreeInorderTraversal().solution(a));
    }
}
