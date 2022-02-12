package leet.soluiton;

import utils.struct.ListNode;

/**
 * @desc: 链表的中间节点
 * @tag: 快慢指针
 */
public class P876 {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
