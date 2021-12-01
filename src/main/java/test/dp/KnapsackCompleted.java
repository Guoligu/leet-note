package test.dp;

import utils.Tool;

import java.util.Arrays;
import java.util.function.DoublePredicate;

public class KnapsackCompleted {

    static int n = 2;
    static int c = 10;
    static int[] v = {5, 8};
    static int[] w = {5, 7};

    public static void main(String[] args) {
        KnapsackCompleted solution = new KnapsackCompleted();
        int ans = solution.f3(n-1, c);
        System.out.println(ans);
    }

    Integer[][] dp = new Integer[n][c+1];

    public int f1(int n, int c) {
        if (n < 0 || c <= 0) {
            return 0;
        }
        if (dp[n][c] != null) {
            return dp[n][c];
        }

        int dp1 = f1(n-1, c);
        int dp2 = 0;
        if (c >= w[n]) {
            dp2 = f1(n, c-w[n]) + v[n];
        }
        dp[n][c] = Math.max(dp1, dp2);

        return dp[n][c];
    }

    public int f2(int n, int c) {
        int[][] dp = new int[n+1][c+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < c+1; j++) {
                if (i < 1) {
                    dp[i][j] = j / w[i] * w[i];
                } else if (j < w[i]) {
                    dp[i][j] = dp[i-1][j];
                } else if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-w[i]] + v[i]);
                }
            }
        }

        return dp[n][c];
    }

    public int f3(int n, int c) {
        int[] dp = new int[c+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = w[i]; j < c+1; j++) {
                dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
            }
        }

        return dp[c];
    }

}
