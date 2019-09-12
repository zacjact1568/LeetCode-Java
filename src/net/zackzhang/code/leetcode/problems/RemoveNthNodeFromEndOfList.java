package net.zackzhang.code.leetcode.problems;

import net.zackzhang.code.leetcode.common.ListNode;

/** 19# 删除链表的倒数第N个节点 */
public class RemoveNthNodeFromEndOfList {

    private ListNode solution(ListNode head, int n) {
        // 添加辅助头节点
        // 防止要删除的就是 head
        // 题目保证 n 一定有效，所以 tempHead 肯定不会被删除
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode fast = tempHead, slow = tempHead;
        // fast 先走 n 步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 两个指针一起走
        // 当 fast 指向链表尾部节点时
        // slow 就是要删除节点的前驱节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        // tempHead 的下一个节点就是真实的头节点
        return tempHead.next;
    }

    public static void test() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(new RemoveNthNodeFromEndOfList().solution(a, 5).val);
    }
}
