package leet.soluiton;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @desc: 下一个更大元素2
 * @tag: 单调栈
 */
public class P503 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }

        int n = nums.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // 将数组延长一倍实现循环数组
        for (int i = 2*n-1; i >= 0; i--) {
            int realI = i % n;
            while (!stack.isEmpty() && stack.peek() <= nums[realI]) {
                stack.pop();
            }
            ans[realI] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[realI]);
        }

        return ans;
    }
}
