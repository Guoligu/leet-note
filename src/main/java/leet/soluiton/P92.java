package leet.soluiton;


import utils.Tool;
import utils.struct.ListNode;

/**
 * @desc: 反转链表2
 */
public class P92 {

    public static void main(String[] args) {
        P92 p = new P92();
        ListNode node = p.reverseBetween(Tool.createListNode("[1,2,3,4,5]"), 1, 2);
        Tool.showListNode(node);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        // prev 指针在 left-1 位置上
        // 设置了 dummyNode 用于记录第一个元素之前的元素，保证 left==1 时程序也能正确执行
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        for (int i = 0; i <= left-2; i++) {  // i 表示prev所在的位置
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode next;
        for (int i = left; i <= right-1; i++) {  // i 表示curr所在的位置
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummyNode.next;
    }

}
