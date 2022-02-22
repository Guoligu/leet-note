package leet.soluiton;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @desc: 柱状图中最大的矩形
 * @tag: 单调栈
 */
public class P84 {
    public static void main(String[] args) {
        P84 p = new P84();
        int ans = p.largestRectangleArea(new int[]{0, 9});
        System.out.println(ans);
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();  // 单调递增，存的是heights下标
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();  // 记住清空栈
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i]  - 1;
            max = Math.max(max, width * heights[i]);
        }

        return max;
    }
}
