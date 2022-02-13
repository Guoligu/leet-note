package leet.soluiton;

/**
 * @desc: 寻找左侧边界，左闭右开区间 [l, r)
 * @tag: 二分查找
 *
 */
public class P34 {


    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }

        int l = leftBound(nums, target);
        int r = rightBound(nums, target);

        return new int[] {l, r};
    }

    public int leftBound(int[] nums, int target) {

        int l = 0;
        int r = nums.length;

        while (l < r) {

            int m = l + (r - l) / 2;

            if (target == nums[m]) {
                r = m;
            } else if (target < nums[m]) {
                r = m;
            } else if (target > nums[m]) {
                l = m + 1;
            }
        }

        if (l == nums.length) {
            return -1;
        }
        return target == nums[l] ? l : -1;
    }

    public int rightBound(int[] nums, int target) {

        int l = 0;
        int r = nums.length;

        while (l < r) {

            int m = l + (r - l) / 2;

            if (target == nums[m]) {
                l = m + 1;
            } else if (target > nums[m]) {
                l = m + 1;
            } else if (target < nums[m]) {
                r = m;
            }
        }

        if (l == 0) {
            return -1;
        }
        return target == nums[l-1] ? l-1 : -1;
    }
}
