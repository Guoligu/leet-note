package test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer[]> solution = solution(new int[]{3, 2, 5, 4, 6, 1});
        for (Integer[] arr : solution) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static List<Integer[]> solution(int[] arr) {
        // 在这⾥写代码
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        List<Integer[]> ans = new ArrayList<>();
        int n = arr.length;

        // i : 0l/1r
        Integer[][] temp = new Integer[n][2];

        // left
        Deque<Integer[]> left = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!left.isEmpty() && left.peek()[0] >= arr[i]) {
                left.pop();
            }
            temp[i][0] = left.isEmpty() ? -1 : left.peek()[1];
            left.push(new Integer[] {arr[i], i});
        }

        // right
        Deque<Integer[]> right = new LinkedList<>();
        for (int i = n-1; i >= 0; i--) {
            while (!right.isEmpty() && right.peek()[0] >= arr[i]) {
                right.pop();
            }
            temp[i][1] = right.isEmpty() ? -1 : right.peek()[1];
            right.push(new Integer[] {arr[i], i});
        }

        // build ans
        for (int i = 0; i < n; i++) {
            ans.add(new Integer[] {temp[i][0], temp[i][1]});
        }

        return ans;
    }
}
