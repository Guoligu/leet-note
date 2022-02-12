package leet.soluiton;

/**
 * @desc: 二分查找
 * @tag: 二分查找
 */
public class p704 {

    // 细节是魔鬼
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length-1; // 1.这里要 -1

        while (l <= r) { // 2.这里要 <= 号

            int m = (l + r) / 2;

            if (nums[m] == target) {
                return m;
            } else if (target < nums[m]) {
                r = m - 1;
            } else if (target > nums[m]) {  // 3.所有 else 写 if ，逻辑更清晰
                l = m + 1;
            }

        }

        return -1;
    }
}
