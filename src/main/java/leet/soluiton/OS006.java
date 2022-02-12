package leet.soluiton;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 */
public class OS006 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {

            int sum = numbers[l] + numbers[r];

            if (sum == target) {
                return new int[] {l , r};
            } else if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            }
        }

        return null;
    }
}
