package leet.soluiton;

/**
 * @desc: 只出现一次的数字
 * @tag: 位运算
 * @tag: 异或
 * @tag: 去重
 */
public class P136 {

    public int singleNumber(int[] nums) {

        int ans = 0;

        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }
}
