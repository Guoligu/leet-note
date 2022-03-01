package leet.soluiton;

import utils.struct.ListNode;

/**
 * @desc: 删除倒数第n个节点
 * @tag: 双指针
 *
 */
public class P19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {  // n从1开始计数
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode tail = head;

        for (int i = 1; i <= n; i++) {  // tail到了n+1的位置
            tail = tail.next;
        }

        while (tail != null) {  // tail到了最后一个的位置，prev 到了倒数n+1的位置
            tail = tail.next;
            prev = prev.next;
        }

        prev.next = prev.next.next;
        return dummy.next;
    }
}
