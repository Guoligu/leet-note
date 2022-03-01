package leet.soluiton;

/**
 * @desc: 移动零
 * @tag: 双指针
 */
public class P283 {
    public void moveZeroes(int[] nums) {
        int right = 0;
        int left = 0;

        // right一直向前走，left遇到0则停一次
        // left在第一次遇到0之前，right==left
        // left在遇到0之后，每次都指向最左边的0
        while (right < nums.length) {
            if (nums[right] != 0) { // 只有在right不为0时才交换
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
