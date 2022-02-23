package test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
//        m.generate(4);
        double ans = m.maxProfit(new double[]{1, 5, 2});
        System.out.println(ans);
    }

    public ArrayList<ArrayList<Integer>> generate (int numRows) {
        // write code here
        int[][] triangle = new int[numRows][numRows];

        for (int i = 0; i < numRows; i++) {
            triangle[i][i] = 1;
            triangle[i][0] = 1;
        }

        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i-1][j] + triangle[i-1][j-1];
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> line = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                line.add(triangle[i][j]);
            }
            ans.add(line);
        }

        return ans;
    }

    public double maxProfit (double[] prices) {
        // write code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        Deque<Double> stack = new ArrayDeque<>();
        double ans = 0;
        double maxElem = prices[0];
        double minElem = prices[0];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= prices[i]) {
                maxElem = stack.pop();
                ans = Math.max(ans, maxElem - minElem);
            }
            minElem = stack.isEmpty() ? prices[i] : minElem;
            stack.push(prices[i]);
        }

        return ans;
    }

    public double maxProfit2 (double[] prices) {
        // write code here

        int n = prices.length;
        double ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                ans = Math.max(ans, prices[j] - prices[i]);
            }
        }

        return ans;
    }
}
