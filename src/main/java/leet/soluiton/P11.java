package leet.soluiton;

/**
 * @desc: 盛最多水的容器
 * @tag: 双指针
 */
public class P11 {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int res = 0;
        int i = 0, j = height.length-1;
        while (i != j) {
            int area = 0;
            if (height[i] <= height[j]) {
                area = height[i] * (j - i);
                i++;
            } else {
                area = height[j] * (j - i);
                j--;
            }
            res = Math.max(area, res);
        }


        return res;
    }
}
