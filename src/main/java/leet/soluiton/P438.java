package leet.soluiton;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc: 找到字符串中所有字母异位词
 * @tag: 滑动窗口
 */
public class P438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int m = p.length();
        int[] window = new int[26];
        int[] need = new int[26];
        int valid = 0;
        int cnt = 0;
        // init
        for (int i = 0; i < m; i++) {
            if (need[p.charAt(i)-'a'] == 0) {
                valid++;
            }
            need[p.charAt(i) - 'a']++;
        }

        int right = 0;  // [left, right),  left = right - m;
        while (right < m-1) {
            int rPos = s.charAt(right) - 'a';
            window[rPos] ++;
            if (window[rPos] == need[rPos]) {
                cnt++;
            }
            right++;
        }

        while (right < n) {
            int rPos = s.charAt(right) - 'a';
            window[rPos] ++;
            if (window[rPos] == need[rPos]) {
                cnt++;
            }
            right++;

            int left = right-m;
            int lPos = s.charAt(left) - 'a';
            if (valid == cnt) {
                ans.add(left);
            }
            if (window[lPos] == need[lPos]) {
                cnt--;
            }
            window[lPos]--;

        }

        return ans;
    }
}
