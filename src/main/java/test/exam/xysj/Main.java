package test.exam.xysj;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int ans = m.lengthOfLongestSubstring("pwwkew");
        System.out.println(ans);
    }

    public int lengthOfLongestSubstring (String s) {
        // write code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int r = 0;
        int[] letters = new int[26];
        int ans = 1;

        for (int l = 0; l < n; l++) {
            while (r < n && letters[s.charAt(r)-'a'] == 0) {
                letters[s.charAt(r)-'a']++;
                r++;
            }
            ans = Math.max(ans, r - l);
            letters[s.charAt(l)-'a']--;
        }

        return ans;
    }
}
