package test.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 找零钱
 */
public class Coins {

    static int k = 3;
    static int amount = 16;
    static List<Integer> coins = new ArrayList<>();
    {
        coins.add(1);
        coins.add(2);
        coins.add(5);
    }

    public static void main(String[] args) {
        Coins solution = new Coins();
        int ans = solution.f2(amount);
        System.out.println(ans);
    }

    /**
     * 穷举
     */
    public int f1(int n) {
        if (n < 0) {
            return Integer.MAX_VALUE - 1;
        }
        if (n == 0) {
            return 0;
        }


        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            res = Math.min( f1(n-coin)+1, res );
        }

        return res;
    }

    /**
     * 记忆化搜索 解决重叠子问题
     */
    Integer[] dp = new Integer[amount+1];

    public int f2(int n) {
        if (n < 0) {
            return Integer.MAX_VALUE - 1;
        }
        if (n == 0) {
            return 0;
        }
        if (dp[n] != null) {
            return dp[n];
        }

        dp[n] = Integer.MAX_VALUE;
        for (int coin : coins) {
            dp[n] = Math.min( f2(n-coin)+1, dp[n]);
        }

        return dp[n];
    }

    /**
     * 自底向上 减少函数递归使用的栈空间，优化空间
     */
    public int f3(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin) continue;
                dp[i] = Math.min(dp[i-coin]+1, dp[i]);
            }
        }
        return dp[n];
    }

}
