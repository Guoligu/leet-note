package leet.soluiton;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @desc: P155最小栈
 * @tag: 辅助栈
 */
public class MinStack {
    Deque<Integer> major = new ArrayDeque<>();
    Deque<Integer> assist = new ArrayDeque<>();

    public MinStack() {
        // 设置哨兵，可以消除判断栈底的开销，assist.size() == major.size()+1
        assist.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        assist.push(Math.min(val, assist.peek()));
        major.push(val);
    }

    public void pop() {
        major.pop();
        assist.pop();
    }

    public int top() {
        return major.peek();
    }

    public int getMin() {
        return assist.peek();
    }
}
