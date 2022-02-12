package leet.soluiton;

import utils.struct.ListNode;

/**
 * @desc: 反转链表
 */
public class P206 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // 记录下一个指针的位置，定义在循环里面是让写法更优雅
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
