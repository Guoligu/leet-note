package leet.soluiton;

import utils.struct.ListNode;

/**
 * 剑指offer22.链表中倒数第k个节点
 */
public class O22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        ListNode tail = head;

        for (int i = 0; i < k; i++) {
            tail = tail.next;
        }

        // p与tail相隔了k-1个元素
        while (tail != null) {
            tail = tail.next;
            p = p.next;
        }

        return p;
    }
}
