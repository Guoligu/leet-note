package leet.soluiton;

import utils.Tool;
import utils.struct.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 回文链表
 * @tag: 双指针
 * @tag: 快慢指针
 */
public class P234 {
    public static void main(String[] args) {
        P234 p = new P234();
        boolean ans = p.isPalindrome(Tool.createListNode("[1,2,1]"));
        System.out.println(ans);
    }

    public boolean isPalindrome(ListNode head) {
        return s1(head);
    }

    public boolean s1(ListNode head) {
        if (head == null) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        ListNode tail = head;
        while (tail != null) {
            list.add(tail.val);
            tail = tail.next;
        }
        int n = list.size();
        int l = 0;
        int r = n-1;
        while (l < r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean s2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == null) {
            return false;
        }

        // 没写完
        return false;
    }
}
