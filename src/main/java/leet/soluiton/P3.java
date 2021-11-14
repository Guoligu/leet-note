package leet.soluiton;

import java.util.HashSet;
import java.util.Set;

/**
 * @desc: 无重复字符的最长子串
 * @tag: 滑动窗口
 */
public class P3 {
    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring("pwwkew");
        System.out.println(ans);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        int r = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();

        // 左边界遍历
        for (int l = 0; l < n; l++) {

            while (r < n && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }

             res = Math.max(res, r - l);

            // 更新hash表
            set.remove(s.charAt(l));
        }

        return res;
    }
}
