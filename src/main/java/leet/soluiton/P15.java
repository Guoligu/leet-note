package leet.soluiton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @desc: 三数之和
 * @tag: 双指针
 */
public class P15 {
    public static void main(String[] args) {
        P15 p = new P15();
        List<List<Integer>> ans = p.threeSum(new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4});

        for (List<Integer> triple : ans) {
            System.out.println(triple);
        }
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int n = nums.length;
        Arrays.sort(nums);

        for (int k = 0; k < n; k++) {
            // 循环 k，有重复的元素直接跳过
            if (k > 0 && nums[k] == nums[k-1]) {
                continue;
            }

            int i = k+1;
            int j = n-1;
            int target = -nums[k];
            while (i < j) {
                // 循环 i，有重复的元素直接跳过
                while (i < j && i > k+1 && nums[i] == nums[i-1]) {
                    i++;
                }
                if (i >= j) {
                    break;
                }
                // 移动双指针
                if (nums[i] + nums[j] == target) {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    // 当c确定时，有且仅有一个a和一个b满足 a+b+c = 0
                    i++;
                    j--;
                } else if (nums[i] + nums[j] > target) {
                    j--;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                }
            }

        }

        return  res;
    }

}
