package leet.soluiton;

/**
 * @desc: 买卖股票的最佳时机1
 * @tag: 股票系列
 */
public class P121 {

    /**
     * 使用minPrice记录“历史”最低价格，计算“今天”相较于“历史最低”能赚多少
     * “今天”之前都是“历史”
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }
}
