package utils.sort;

import java.util.Arrays;

/**
 * 用于数组的内部排序
 */
public class ArraySort {

    public static void main(String[] args) {
        int[] a = {3, 2, 4, 6, 1};
//        int[] a = {1, 1, 1, 1, 1};
//        int[] a = {1, 2, 3, 4, 5, 6};
//        int[] a = {6, 5, 4, 3, 2, 7, 1};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 改进冒泡排序，稳定
     * 时间复杂度：平均 O(n^2)，最差 O(n^2)
     * 空间复杂度：O(1)
     *
     */
    public static void bubbleSort(int[] a) {
        int n = a.length;
        boolean isContinue = true;
        int i = 0;

        while (isContinue) {
            // 假设此次没有元素交换
            isContinue = false;
            // 两两交换
            for (int j = 0; j < n-i-1; j++) {
                if (a[j] > a[j+1]) {
                    swap(a, j, j+1);
                    isContinue = true;
                }
            }
            // 更新
            i++;
        }
    }

    /**
     * 选择排序，不稳定
     * 时间复杂度：平均 O(n^2), 最差 O(n^2)
     * 空间复杂度：O(1)
     */
    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {

            int pos = i;
            for (int j = i+1; j < n; j++) {
                if (a[pos] > a[j]) {
                    pos = j;
                }
            }

            if (pos != i) {
                swap(a, i ,pos);
            }
        }
    }

    /**
     * 插入排序，稳定
     * 时间复杂度：平均 O(n^2), 最差 O(n^2)
     * 空间复杂度：O(1)
     */
    public static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 1; j--) {
                if (a[j] < a[j-1]) {
                    swap(a, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 快速排序
     * 不同的写法稳定性不同，本写法为稳定写法，在数组中存在大量相同元素时，时间复杂度会退化到O(n^2)
     * 时间复杂度：平均 O(nlogn), 最坏 O(n^2)
     * 空间复杂度：O(nlogn)
     */
    public static void quickSort(int[] a) {
        quickSort(0, a.length-1, a);
    }

    private static void quickSort(int l, int r, int[] a) {
        if (l >= r) {
            return;
        }

        int i = l;
        int j = r;
        int key = a[l];
        // 找到key的正确位置
        while (i < j) {
            while (i < j && a[j] >= key) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }

            while (i < j && a[i] <= key) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }

        a[i] = key;
        quickSort(l, i-1, a);
        quickSort(i+1, r, a);

    }

    /**
     * 归并排序，稳定
     * 时间复杂度：平均 O(nlogn), 最差 O(n^2)
     * 空间复杂度：O(n)
     */
    public static void mergeSort(int[] a) {
        int[] c = new int[a.length];
        mergeSort(0, a.length-1, a, c);
    }

    private static void mergeSort(int l, int r, int[] a, int[] c) {
        if (l == r) {
            return;
        }

        int mid = (l + r) >> 1;
        mergeSort(l, mid, a, c);
        mergeSort(mid+1, r, a, c);
        int i = l;
        int j = mid + 1;
        int cnt = l;

        while (i <= mid && j <= r) {
            if (a[i] < a[j]) {
                c[cnt++] = a[i];
                i++;
            } else {
                c[cnt++] = a[j];
                j++;
            }
        }
        while (i <= mid) {
            c[cnt++] = a[i];
            i++;
        }
        while (j <= r) {
            c[cnt++] = a[j];
            j++;
        }

        for (int k = l; k <= r; k++) {
            a[k] = c[k];
        }
    }


    /**
     * 堆排序
     */
    public static void heapSort(int[] a) {
        int len = a.length;

        // 构建大根堆
        for (int i = len/2-1; i >= 0;  i--) {
            heapify(a, i, len);
        }

        // 排序
        for (int i = len-1; i >= 0; i--) {
            swap(a, 0, i);
            len--;
            heapify(a, 0, len);
        }
    }

    private static void heapify(int[] a, int i, int len) {
        int pos = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < len && a[l] > a[pos]) {
            pos = l;
        }
        if (r < len && a[r] > a[pos]) {
            pos = r;
        }
        if (pos != i) {
            swap(a, pos, i);
            heapify(a, pos, len);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    /**
     * 基数排序
     */

    /**
     * 希尔排序
     */
}
