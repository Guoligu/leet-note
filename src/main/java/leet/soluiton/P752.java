package leet.soluiton;

import utils.Tool;

import java.util.*;

/**
 * @desc: 打开转盘锁
 * @tag: bfs
 * @tag: 启发式搜索
 *
 */
public class P752 {
    public static void main(String[] args) {
        P752 p = new P752();
        int step = p.openLock(Tool.createStringArr("[\"8887\",\"8889\",\"8878\",\"8898\",\"8788\",\"8988\",\"7888\",\"9888\"]"), "8888");
        System.out.println(step);
    }

    public int openLock(String[] deadends, String target) {
        return s2(deadends, target);
    }

    /**
     * 方法一：bfs，判断当前
     */
    public int s1(String[] deadends, String target) {
        if (target == null) {
            return -1;
        }
        if (deadends == null) {
            deadends = new String[] {};
        }
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> deadSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Collections.addAll(deadSet, deadends);
        int step = 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                String status = queue.poll();
                if (target.equals(status)) {
                    return step;
                }
                if (deadSet.contains(status) || visited.contains(status)) {
                    continue;
                }
                visited.add(status);

                List<String> adjList = adj(status);
                for (String nextStatus : adjList) {
                    queue.offer(nextStatus);
                }

            }

            step++;

        }

        return -1;
    }

    /**
     * 得到邻居status列表
     */
    public List<String> adj(String status) {

        List<String> res = new ArrayList<>();
        char[] statusArr = status.toCharArray();

        for (int i = 0; i < 4; i++) {

            char num = statusArr[i];
            // 向上拨
            statusArr[i] = up(num);
            res.add(new String(statusArr));
            // 向下拨
            statusArr[i] = down(num);
            res.add(new String(statusArr));

            statusArr[i] = num;
        }
        return res;
    }

    public char up(char num) {
        return num == '9' ? '0' : (char) (num + 1);
    }

    public char down(char num) {
        return num == '0' ? '9' : (char) (num - 1);
    }


    /**
     * 方法二：bfs，判断下一个，快了一点点
     */
    public int s2(String[] deadends, String target) {
        if (target == null) {
            return -1;
        }
        if (deadends == null) {
            deadends = new String[] {};
        }
        if ("0000".equals(target)) {
            return 0;
        }


        Set<String> deadSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Collections.addAll(deadSet, deadends);
        int step = 0;

        if (deadSet.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        while (!queue.isEmpty()) {

            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                String status = queue.poll();
                List<String> adjList = adj(status);

                for (String nextStatus : adjList) {

                    if (target.equals(nextStatus)) {
                        return step;
                    }
                    if (deadSet.contains(nextStatus) || visited.contains(nextStatus)) {
                        continue;
                    }

                    visited.add(nextStatus);
                    queue.offer(nextStatus);
                }

            }

        }

        return -1;
    }


    /**
     * 方法3：启发式搜索，不会
     */
}
