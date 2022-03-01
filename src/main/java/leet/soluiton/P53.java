package leet.soluiton;

/**
 * @desc: 最大子数组和
 * @tag: dp
 */
public class P53 {

    /**
     * dp(i) = max( dp(i-1) + nums[i], nums[i] )
     * dp(i)表示以i结束的序列的最大和
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = nums[0];
        int prev = nums[0];
        int curr = 0;
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(prev + nums[i], nums[i]);
            ans = Math.max(ans, curr);
            prev = curr;
        }

        return ans;
    }
}
