package leet.soluiton;


import utils.struct.ListNode;

/**
 * @desc: 反转链表2
 */
public class P92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;

        int pos = 1;
        while (pos < left-1) {
            curr = curr.next;
            pos++;
        }

        ListNode lp = curr;
        curr = curr.next;
        pos++;

        ListNode prev = curr;
        while (pos < right-1) {
            curr = curr.next;
            prev.next = curr.next;
            curr.next = lp.next;
            lp.next = curr;

            curr = prev.next;

            pos++;
        }

        return head;

    }
}
