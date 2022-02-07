package utils;

import utils.struct.ListNode;

import java.util.Arrays;

public class Tool {
    public static void showTwoDimArr(Integer[][] a) {
        if (a == null || a.length == 0) {
            System.out.println("null arr");
            return;
        }

        for (Integer[] line : a) {
            for (Integer x : line) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static void showTwoDimArr(int[][] a) {
        if (a == null || a.length == 0) {
            System.out.println("null arr");
            return;
        }

        for (int[] line : a) {
            for (int x : line) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static void showTwoDimArrWithIdx(Integer[][] a) {
        if (a == null || a.length == 0) {
            System.out.println("null arr");
            return;
        }

        int m = 0;
        for (int i = 0; i < a.length; i++) {
            int len = 0;
            if (a[i] != null) {
                len = a[i].length;
            }
            m = Math.max(len, m);
        }

        System.out.print("  ");
        for (int i = 0; i < m; i++) {
            System.out.print(i + "\t\t");
        }
        System.out.println();
        for (int i = 0; i < m * 8; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < a.length; i++) {
            System.out.print(i + "|");
            if (a[i] != null) {
                for (int j = 0; j < a[i].length; j++) {
                    System.out.print(a[i][j] + "\t\t");
                }
            }
            System.out.println();
        }
    }

    public static void showTwoDimArrWithIdx(int[][] a) {
        if (a == null || a.length == 0) {
            System.out.println("null arr");
            return;
        }

        int m = 0;
        for (int i = 0; i < a.length; i++) {
            int len = 0;
            if (a[i] != null) {
                len = a[i].length;
            }
            m = Math.max(len, m);
        }

        System.out.print("  ");
        for (int i = 0; i < m; i++) {
            System.out.print(i + "\t\t");
        }
        System.out.println();
        for (int i = 0; i < m * 8; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < a.length; i++) {
            System.out.print(i + "|");
            if (a[i] != null) {
                for (int j = 0; j < a[i].length; j++) {
                    System.out.print(a[i][j] + "\t\t");
                }
            }
            System.out.println();
        }
    }


    // 数字字符串"[1, 2, 3]" -> 链表
    public static ListNode createListNode(String str) {
        // 检查字符串是否合法
        
        // 解析字符串
        String noSquareBracketsStr = str.substring(1, str.length()-1);
        String[] elemsStrArr = noSquareBracketsStr.split(",");

        int[] elems = new int[elemsStrArr.length];
        for (int i = 0; i < elemsStrArr.length; i++) {
            int elem = Integer.parseInt(elemsStrArr[i].trim());
            elems[i] = elem;
        }

        // 生成链表
        ListNode head = new ListNode();
        ListNode tail = head;

        for (int elem : elems) {
            tail.next = new ListNode();
            tail = tail.next;

            tail.val = elem;
        }

        return head.next;
    }

    public static void showListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
