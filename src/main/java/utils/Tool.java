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


    // 数字字符串[1, 2, 3] -> 链表
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

    // 字符串["0201","0101","0102","1212","2002"] -> 字符串数组
    public static String[] createStringArr(String str) {
        // 检查字符串是否合法

        // 解析字符串
        String noSquareBracketsStr = str.substring(2, str.length()-2);
        return noSquareBracketsStr.split("\",\"");
    }

    public static void showListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static char[][] createTwoDimArr(String input) {

        String oneBracketStr = input.substring(2, input.length()-2);
        String[] oneDimStrArr = oneBracketStr.split("],\\[");

        int n = oneDimStrArr.length;
        int m = oneDimStrArr[0].split(",").length;
        char[][] res = new char[n][m];

        int i = 0;
        for (String oneDimStr : oneDimStrArr) {
            String noDimStr = oneDimStr.trim().substring(1,oneDimStr.length()-1);
            String[] elemStrArr = noDimStr.split("\",\"");
            int j = 0;
            for (String elemStr :elemStrArr) {
                res[i][j] = elemStr.charAt(0);
                j++;
            }
            i++;
        }

        return res;
    }


    public static void showTwoDimArr(char[][] a) {
        if (a == null || a.length == 0) {
            System.out.println("null arr");
            return;
        }

        for (char[] line : a) {
            for (char x : line) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    // head表示链表头，pos表示环形的起始位置
    public static ListNode createCircularList(ListNode head, int pos) {


        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        ListNode cycle = head;
        for (int i = 0; i < pos; i++) {
            cycle = cycle.next;
        }

        tail.next = cycle;

        return head;
    }
}
