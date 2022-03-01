package leet.soluiton;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 有效的括号
 * @tag:
 */
public class P20 {
    public static void main(String[] args) {
        P20 p = new P20();
        boolean ans = p.isValid("()");
        System.out.println(ans);
    }

    public boolean isValid(String s) {
        return s2(s);
    }

    /**
     * 更漂亮的写法
     */
    public boolean s2(String s) {
        if (s == null || s.length() == 0 || (s.length() & 1) == 1) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public boolean s1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
            }
        }

        return stack.isEmpty();
    }
}
