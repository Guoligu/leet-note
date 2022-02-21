package leet.soluiton;

/**
 * @desc: 字符串的排列
 * @tag: 滑动窗口
 */
public class P567 {
    public static void main(String[] args) {
        P567 p = new P567();
//        boolean ans = p.checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine");
        boolean ans = p.checkInclusion("ab", "eidboaoo");
        System.out.println(ans);
    }

    public boolean checkInclusion(String s1, String s2) {

        int l = 0;
        // int r = 0;
        int valid = 0;

        int[] window = new int[26];
        int[] need = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            if (need[s1.charAt(i)-'a'] == 0) {
                valid++;
            }
            need[s1.charAt(i)-'a'] ++;
        }


        for (int r = 0; r < s2.length(); r++) {
            char rLetter = s2.charAt(r);
            if (rLetter == 't') {
                System.out.println();
            }
            if (need[rLetter-'a'] > 0) {
                window[rLetter-'a']++;
                if (window[rLetter-'a'] == need[rLetter-'a']) {
                    valid--;
                }
            }

            if (r < s1.length()-1) {
                continue;
            }
            char lLetter = s2.charAt(l);
            l++;
            if (valid == 0) {
                return true;
            }
            if (need[lLetter-'a'] > 0) {
                if (window[lLetter-'a'] == need[lLetter-'a']) {
                    valid++;
                }
                window[lLetter-'a']--;
            }

        }

        return false;
    }
}
