package net.zackzhang.code.leetcode.problems;

import net.zackzhang.code.leetcode.common.ListNode;

/** 23# 合并K个排序链表 */
public class MergeKSortedLists {

    private ListNode solution(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        // 步长（窗口长度）
        int step = 1;
        while (step < len) {
            for (int i = 0; i < len - step; i += step * 2) {
                // 将合并后链表的头节点放到窗口的第一个位置
                lists[i] = merge(lists[i], lists[i + step]);
            }
            step *= 2;
        }
        return lists[0];
    }

    // 合并两个排序链表
    private ListNode merge(ListNode head1, ListNode head2) {
        // 辅助头节点
        ListNode head = new ListNode(0);
        // 当前的尾节点
        ListNode tail = head;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        // 此时，head1 和 head2 最多只可能有一个为 null
        tail.next = head1 != null ? head1 : head2;
        return head.next;
    }

    public static void test() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(6);
        c1.next = c2;
        System.out.println(new MergeKSortedLists().solution(new ListNode[]{a1, b1, c1}));
    }
}
