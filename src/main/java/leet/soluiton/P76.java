package leet.soluiton;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 最小覆盖子串
 * @tag: 滑动窗口
 *
 */
public class P76 {
    public static void main(String[] args) {
        P76 p = new P76();
        String ans = p.minWindow("aa", "aa");
        System.out.println(ans);
    }

    /**
     * hash表版本
     */
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;  // 左闭右开 [left, right)
        int ansStart = 0;
        int ansLen = Integer.MAX_VALUE;
        int valid = 0;

        while (right < s.length()) {
            // 外循环移动right
            char in = s.charAt(right);
            if (!need.containsKey(in)) {
                right++;
                continue;
            }

            int getR = window.getOrDefault(in, 0) + 1;
            window.put(in, getR);
            if (getR == need.get(in)) {
                valid++;
            }

            right++;

            // 内循环移动left
            while (valid == need.size()) {

                char out = s.charAt(left);
                if (!need.containsKey(out)) {
                    left++;
                    continue;
                }

                int getL = window.get(out) - 1;
                window.put(out, getL);
                if (getL < need.get(out)) {
                    valid--;
                    // 在结束left移动时更新答案
                    if (ansLen > right - left) {
                        ansLen = right - left;
                        ansStart = left;
                    }
                }

                left++;

            }

        }

        return ansLen == Integer.MAX_VALUE ? "" : s.substring(ansStart, ansStart + ansLen);
    }


}
