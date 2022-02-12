package leet.soluiton;

import utils.Tool;
import utils.struct.ListNode;

/**
 * @desc: 环形链表的入口
 * @tag: 双指针
 */
public class P142 {
    public static void main(String[] args) {
        P142 p = new P142();
        ListNode head = Tool.createListNode("[3,2,0,-4]");
        Tool.createCircularList(head, 1);

        ListNode node = p.detectCycle(head);
        System.out.println(node.val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean isCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {  // 找到相遇点
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
