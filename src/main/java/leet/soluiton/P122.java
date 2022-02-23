package leet.soluiton;

/**
 * @desc: 买卖股票的最佳时机 2
 * @tag: dp
 */
public class P122 {
    public static void main(String[] args) {
        P122 p = new P122();
        int ans = p.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(ans);
    }

    public int maxProfit(int[] prices) {
        return s3(prices);
    }

    /**
     * 解法一：数组dp
     */
    public int s1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[][] dp = new int[n][2];  // 第i天 持有/未持有 股票的最大利润，dp[i][1] / dp[i][0]
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]); // 昨天没有今天无操作； 昨天有但今天卖了
            dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]); // 昨天没有但今天买了； 昨天有今天没卖
        }

        return dp[n-1][0];
    }

    /**
     * 解法二：优化空间
     */
    public int s2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int preOwn = -prices[0];
        int preWithout = 0;
        int todayOwn = 0;
        int todayWithout = 0;

        for (int i = 1; i < n; i++) {
            todayWithout = Math.max(preWithout, preOwn+prices[i]);
            todayOwn = Math.max(preWithout-prices[i], preOwn);

            preWithout = todayWithout;
            preOwn = todayOwn;
        }

        return todayWithout;
    }

    /**
     * 解法三：贪心
     */
    public int s3(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            ans += Math.max(0, prices[i]-prices[i-1]);
        }

        return ans;
    }
}
