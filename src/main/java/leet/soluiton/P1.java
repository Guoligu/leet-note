package leet.soluiton;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 两数之和
 * @tag: 哈希表
 */
public class P1 {
    public int[] twoSum(int[] nums, int target) {
        // element : index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - nums[i];

            if ( map.containsKey(b) ) {
                return new int[] {i, map.get(b)};
            } else {
                map.put(a, i);
            }
        }

        return null;
    }
}
