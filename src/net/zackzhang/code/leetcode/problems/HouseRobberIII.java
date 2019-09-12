package net.zackzhang.code.leetcode.problems;

import net.zackzhang.code.leetcode.common.TreeNode;

/** 337# 打家劫舍 III */
public class HouseRobberIII {

    private int solution(TreeNode root) {
        int[] res = rob(root);
        return Math.max(res[0], res[1]);
    }

    private int[] rob(TreeNode root) {
        // 用于返回两个值
        // res[0] 为不选 root 时，root 引导的子树的最大值
        // res[1] 为选 root 时，root 引导的子树的最大值
        int[] res = new int[2];
        if (root == null) return res;
        // 递归左右子树
        int[] left = rob(root.left);
        int[] right = rob(root.right);
        // 不选 root，就可以选左右子节点，取左右子树最大值之和
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 选 root，就不能选左右子节点，即 left 和 right 全取 [0]，再加上 root 的值
        res[1] = left[0] + right[0] + root.val;
        return res;
    }

    public static void test() {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.right = d;
        c.right = e;
        System.out.println(new HouseRobberIII().solution(a));
    }
}
