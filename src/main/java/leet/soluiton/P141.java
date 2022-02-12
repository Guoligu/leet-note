package leet.soluiton;

import utils.Tool;
import utils.struct.ListNode;

/**
 * 环形链表
 */
public class P141 {
    public static void main(String[] args) {
        P141 p = new P141();
        ListNode head = Tool.createListNode("[3,2,0,-4]");
//        Tool.createCircularList(head, 1);
        boolean ans = p.hasCycle(head);
        System.out.println(ans);
    }


    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
