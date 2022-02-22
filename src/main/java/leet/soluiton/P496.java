package leet.soluiton;

import java.util.*;

/**
 * @desc: 下一个更大元素1
 * @tag: 单调栈
 * @tag: hash
 */
public class P496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[] {};
        }

        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>(); // e : nge
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = m-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            int nge = stack.isEmpty() ? -1 : stack.peek();
            map.put(nums2[i], nge);
            stack.push(nums2[i]);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = map.get(nums1[i]);
        }

        return arr;
    }
}
