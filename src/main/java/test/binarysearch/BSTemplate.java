package test.binarysearch;

public class BSTemplate {

    /**
     * 普通bs，两侧都是闭区间 [l, r]
     */
    public int bs(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {

            int m = l + (r - l) / 2;

            if (target == nums[m]) {
                return m;
            } else if (target > nums[m]) {
                l = m + 1;
            } else if (target < nums[m]) {
                r = m - 1;
            }
        }

        return -1;
    }

    /**
     * 寻找左侧边界，左闭右开区间 [l, r)
     */
    public int leftBound(int[] nums, int target) {

        int l = 0;
        int r = nums.length;

        while (l < r) { // 到循环结束(当l==r时)才能确定答案

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
        return nums[l] == target ? l : -1;
    }

    /**
     *
     * 寻找又侧边界，左闭右开区间 [l, r)
     */
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


    public static void main(String[] args) {
        BSTemplate template = new BSTemplate();
        int bs = template.rightBound(new int[]{1, 2, 3, 3, 3, 4, 5}, 3);
        System.out.println(bs);
    }

}
