package leet.soluiton;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @desc: 每日气温
 * @tag: 单调栈
 */
public class P739 {
    public static void main(String[] args) {
        P739 p = new P739();
        int[] ans = p.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ans));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[] {};
        }

        int n = temperatures.length;
        Deque<Integer> stack = new LinkedList<>(); // 递减，存的是下标
        int[] answer = new int[n];

        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return answer;
    }
}
