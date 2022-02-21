package leet.soluiton;

/**
 * @tag: 有效的字母异位词
 * @tag: hash
 */
public class P242 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        int n = s.length();
        int m = t.length();

        if (n != m) {
            return false;
        }

        int[] letter = new int[26];
        for (int i = 0; i < n; i++) {
            letter[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < m; i++) {
            if (letter[t.charAt(i) - 'a'] == 0) {
                return false;
            }
            letter[t.charAt(i) - 'a']--;
        }

        return true;
    }
}
