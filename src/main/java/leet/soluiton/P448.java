package leet.soluiton;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 找到所有数组中消失的数字
 * @tag: 哈希
 * @tag: 花里胡哨
 */
public class P448 {
    public static void main(String[] args) {
        P448 p = new P448();
        List<Integer> ans = p.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(ans);
    }


    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int pos = nums[i] > n ? (nums[i]-1) % n : nums[i]-1;
            nums[pos] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ans.add(i+1);
            }
        }

        return ans;
    }
}
