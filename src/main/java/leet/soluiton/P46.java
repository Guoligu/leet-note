package leet.soluiton;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 全排列
 * @tag: 回溯
 */
public class P46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        P46 p = new P46();
        List<List<Integer>> permute = p.permute(nums);

        for (List<Integer> line : permute) {
            System.out.println(line);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        return s1(nums);
    }

    /**
     * 时间复杂度 O(n * n!)
     * 空间复杂度 O(n)
     */
    public List<List<Integer>> s1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> line = new ArrayList<>();
        backtrack(nums, visited, 0, ans, line);

        return ans;
    }

    public void backtrack(int[] nums, boolean[] visited, int idx, List<List<Integer>> ans, List<Integer> line) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(line));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                line.add(nums[i]);
                backtrack(nums, visited, idx+1, ans, line);
                line.remove(idx);
                visited[i] = false;
            }
        }
    }

    /**
     * 时间复杂度 O(n * n!)
     * 空间复杂度 O(1)
     */
    public List<List<Integer>> s2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> line = new ArrayList<>();
        backtrack2(nums, 0, ans, line);

        return ans;
    }

    public void backtrack2(int[] nums, int idx, List<List<Integer>> ans, List<Integer> line) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(line));
        }

        for (int num : nums) {
            if (line.contains(num)) {
                continue;
            }

            line.add(num);
            backtrack2(nums, idx + 1, ans, line);
            line.remove(idx);
        }
    }
}
