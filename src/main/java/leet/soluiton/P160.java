package leet.soluiton;

import utils.struct.ListNode;

/**
 * @desc: 相交链表
 * @tag: 双指针
 */
public class P160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {  // p1 == p2 == null 时结束循环，没有相交
            p1 = p1 == null ? headA : p1.next;
            p2 = p2 == null ? headB : p2.next;
        }

        return p1;
    }
}
