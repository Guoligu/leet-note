package leet.soluiton;

/**
 * @desc: 下一个排序
 * @tag: 双指针
 */
public class P31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int n = nums.length;
        int i = n - 2;
        // 1.找到从右向左第一个非单调递增（>=）的元素，i等于-1表示没有这样的元素
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        // 2.找到从右向左第一个大于（1）的元素，交换他们的位置
        if (i >= 0) {  // 找到这样的较小元素，一定存在nums[i] > nums[i+1]
            int j = n-1;
            while (nums[j] <= nums[i]) {  // 在位置i上，nums[i] > nums[i+1]
                j--;
            }
            swap(i, j, nums);
        }

        // 3.（1）右侧的序列从左
        int l = i+1;
        int r = n-1;
        while (l < r) {
            swap(l, r, nums);
            l++;
            r--;
        }

    }

    public void swap(int l, int r, int[] nums) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
