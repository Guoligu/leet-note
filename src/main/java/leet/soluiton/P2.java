package leet.soluiton;

import utils.Tool;
import utils.struct.ListNode;

/**
 * 两数相加
 */
public class P2 {
    public static void main(String[] args) {
        P2 p = new P2();
        ListNode ans = p.addTwoNumbers(Tool.createListNode("[2, 4, 3]"),
                Tool.createListNode("[5, 6, 4]"));
        Tool.showListNode(ans);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        ListNode p1 = l1;
        ListNode p2 = l2;
        int c = 0;  // 进位 carry

        while (p1 != null || p2 != null) {
            int sum = c;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            // 是否进位
            if (sum > 9) {
                sum -= 10;
                c = 1;
            } else {
                c = 0;
            }
            // 更新
            tail.next = new ListNode(sum);
            tail = tail.next;
        }

        if (c > 0) {
            tail.next = new ListNode(1);
        }

        return head.next;
    }
}
