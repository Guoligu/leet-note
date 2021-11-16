package leet.soluiton;

/**
 * @desc: 寻找两个正序数组的中位数
 * @tag: 二分查找
 */
public class P4 {
    public static void main(String[] args) {
        P4 p = new P4();
        int[] nums1 = {};
        int[] nums2 = {2, 3, 4};
        double ans = p.findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return s1(nums1, nums2);
    }

    /**
     * 方法一：二分查找
     */
    public double s1(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int k = total / 2;
        double res = 0;

        // 将问题转化为查询topk的元素
        if ( (total & 1) == 1 ) {
            res = getElem(nums1, nums2, k);
        } else {
            res = (getElem(nums1, nums2, k-1) + getElem(nums1, nums2, k)) / 2.0;
        }


        return res;
    }

    /**
     *
     * @param k 返回两个数组中第k大的元素，k即要剪裁的元素个数
     */
    public int getElem(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        // 数组中被剪裁的最后一个元素的位置
        int pos1 = -1;
        int pos2 = -1;

        while (true) {
            // 整个数组被剪裁的情况
            if (pos1 == n-1) {
                return nums2[pos2+1+k];
            }
            if (pos2 == m-1) {
                return nums1[pos1+1+k];
            }
            // 剪裁完毕
            if (k == 0) {
                return Math.min(nums1[pos1+1], nums2[pos2+1]);
            }

            // mid表示此轮循环要剪裁的元素个数，采用二分的方式
            int mid = (k == 1 ? 1 : k / 2);
            // 一种值得学习的边界判断方式
            int nextPos1 = Math.min(mid + pos1, n-1);
            int nextPos2 = Math.min(mid + pos2, m-1);

            if ( nums1[nextPos1] < nums2[nextPos2] ) {
                k -= (nextPos1 - pos1);
                pos1 = nextPos1;
            } else {
                k -= (nextPos2 - pos2);
                pos2 = nextPos2;
            }
        }


    }
}
