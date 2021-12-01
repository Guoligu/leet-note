package test.dp;

public class Knapsack01 {

    static int[] w = {2,3,5,5};
    static int[] v = {2,4,3,7};
    static int n = 4;
    static int c = 10;

    public static void main(String[] args) {
        Knapsack01 solution = new Knapsack01();
        int ans = solution.f2(n-1, c);
        System.out.println(ans);
    }

    /**
     * 穷举
     */
    public int f1(int n, int c) {
        if (n < 0 || c <= 0) {
            return 0;
        }

        int dp1 = f1(n-1, c);
        int dp2 = 0;
        if (c >= w[n]) {
            dp2 = f1(n-1, c-w[n]) + v[n];
        }

        return Math.max(dp1, dp2);
    }

    /**
     * 记忆化搜索
     */
    Integer[][] dp = new Integer[n][c+1];

    public int f2(int n, int c) {
        if (n < 0 || c <= 0) {
            return 0;
        }
        if (dp[n][c] != null) {
            return dp[n][c];
        }

        int dp1 = f1(n-1, c);
        int dp2 = 0;
        if (c >= w[n]) {
            dp2 = f1(n-1, c-w[n]) + v[n];
        }
        dp[n][c] = Math.max(dp1, dp2);


        return dp[n][c];
    }

    /**
     * 自底向上
     */
    public int f3(int n, int c) {
        int[][] dp = new int[n+1][c+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < c+1; j++) {
                if (i < 1 && j < w[i]) {
                    dp[i][j] = 0;
                } else if (i < 1 && j >= w[i]) {
                    dp[i][j] = v[i];
                } else if (i >= 1 && j < w[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
                }
            }
        }

        return dp[n][c];
    }

    /**
     * 状态压缩
     */
    public int f4(int n, int c) {
        int[][] dp = new int[2][c+1];

        for (int i = 0; i < n+1; i++) {

            for (int j = 0; j < c+1; j++) {
               if (j < w[i]) {
                   dp[1][j] = dp[0][j];
               } else {
                   dp[1][j] = Math.max(dp[0][j], dp[0][j-w[i]] + v[i]);
               }
           }

           for (int j = 0; j < c+1; j++) {
               dp[0][j] = dp[1][j];
           }

        }
        return dp[0][c];
    }

    /**
     * 更优秀的状态压缩
     */
    public int f5(int n, int c) {
        int[] dp = new int[c+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = c; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
            }
        }

        return dp[c];
    }
}
