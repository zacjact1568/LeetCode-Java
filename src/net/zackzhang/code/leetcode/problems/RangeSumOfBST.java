package net.zackzhang.code.leetcode.problems;

import net.zackzhang.code.leetcode.common.TreeNode;

public class RangeSumOfBST {

    /** 返回根节点为 root 的子树中节点值在 L 和 R 之间的值之和 */
    public int solution(TreeNode root, int L, int R) {
        if (root == null) return 0;
        int val = root.val;
        int now = 0, left = 0, right = 0;
        // 判断 root 是否满足条件
        if (val >= L && val <= R) {
            now = val;
        }
        // 仅当 L 在 root 的左子树中时，才遍历左子树
        if (val > L) {
            left = solution(root.left, L, R);
        }
        // 仅当 R 在 root 的右子树中时，才遍历右子树
        if (val < R) {
            right = solution(root.right, L, R);
        }
        return now + left + right;
    }

    public static void test() {
        // 构造一个 BST
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(15);
        a.left = b;
        a.right = c;
        b.left = new TreeNode(3);
        b.right = new TreeNode(7);
        c.right = new TreeNode(18);
        System.out.println(new RangeSumOfBST().solution(a, 7, 15));
    }
}
