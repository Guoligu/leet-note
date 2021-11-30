package test.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契
 */
public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci solution = new Fibonacci();

        int compare = solution.f1(20);
        System.out.println(compare);

        int ans = solution.f4(20);
        System.out.println(ans);
    }

    /**
     * 穷举
     */
    public int f1(int n) {
        if (n == 1 || n == 0) {
            return n;
        }

        return f1(n-1) + f1(n-2);
    }

    /**
     * 记忆化搜索 解决重叠子问题
     */
    Map<Integer, Integer> map = new HashMap<>();

    public int f21(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int res = f21(n-1) + f21(n-2);
        map.put(n, res);

        return res;
    }

    /**
     * 记忆化搜索 使用dp table
     */
    Integer[] dp = new Integer[100];

    public int f22(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (dp[n] != null) {
            return dp[n];
        }

        dp[n] = f22(n-1) + f22(n-2);

        return dp[n];
    }

    /**
     * 自底向上写法 减少递归栈的使用，优化空间
     */
    public int f3(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    /**
     * 使用滚动数组进行状态压缩 优化dp table空间
     */
    public int f4(int n) {
        if (n == 1  || n == 0) {
            return n;
        }

        int x = 0;
        int y = 1;
        int z = 0;

        for (int i = 2; i <= n; i++) {
            z = x + y;
            x = y;
            y = z;
        }

        return z;
    }



}
