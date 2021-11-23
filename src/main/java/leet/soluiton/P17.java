package leet.soluiton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @desc: 电话号码的字母组合
 * @tag: 回溯
 */
public class P17 {

    public static void main(String[] args) {
        P17 p = new P17();
        List<String> ans = p.letterCombinations("");
        System.out.println(ans);
    }



    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");


        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        backtrace(res, new StringBuffer(), map, digits, 0);

        return res;
    }

    public void backtrace(List<String> res, StringBuffer combination,
                          Map<Character, String> map, String digits, int idx) {
        if (idx == digits.length()) {
            res.add(combination.toString());
            return;
        }

        char digit = digits.charAt(idx);
        char[] letters = map.get(digit).toCharArray();
        for (int i = 0; i < letters.length; i++) {
            combination.append(letters[i]);
            backtrace(res, combination, map, digits, idx+1);
            combination.deleteCharAt(combination.length()-1);
        }

    }

}
