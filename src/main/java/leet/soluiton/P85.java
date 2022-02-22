package leet.soluiton;

import utils.Tool;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @desc: 最大矩形
 * @tag: 单调栈
 */
public class P85 {
    public static void main(String[] args) {
        P85 p = new P85();
//        String input = "[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]\n";
//        String input = "[[\"1\"]]";
        String input = "[[\"0\",\"1\"]]";
        int ans = p.maximalRectangle(Tool.createTwoDimArr(input));
        System.out.println(ans);
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length; // 行数
        int m = matrix[0].length; // 列数
        int[][] heights = new int[n][m];

        // 初始化第一行
        for (int j = 0; j < m; j++) {
            heights[0][j] = matrix[0][j] - '0';
        }

        // build heights array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                heights[i][j] = matrix[i][j] == '0' ? 0 : heights[i-1][j]+1;
            }
        }

        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>(); // 单调递增栈，记录heights下标
        for (int i = 0; i < n; i++) {
            // 在第i行求柱状图中的最大矩形

            int[] left = new int[m];
            stack.clear();
            for (int j = 0; j < m; j++) {
                while (!stack.isEmpty() && heights[i][stack.peek()] >= heights[i][j]) {
                    stack.pop();
                }
                left[j] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(j);
            }

            int[] right = new int[m];
            stack.clear();
            for (int j = m-1; j >= 0; j--) {
                while (!stack.isEmpty() && heights[i][stack.peek()] >= heights[i][j]) {
                    stack.pop();
                }
                right[j] = stack.isEmpty() ? m : stack.peek();
                stack.push(j);
            }

            for (int j = 0; j < m; j++) {
                int width = right[j] - left[j] - 1;
                max = Math.max(max, width * heights[i][j]);
            }
        }

        return max;
    }
}
