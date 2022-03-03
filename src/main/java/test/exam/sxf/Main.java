package test.exam.sxf;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int ans = m.getMedia(new int[] {1,3,5,7,9}, new int[] {2,4,6});
        System.out.println(ans);
    }

    public int getMedia (int[] arr1, int[] arr2) {
        // write code here
        if (arr1 == null || arr2 == null) {
            return 0;
        }

        int n = arr1.length;
        int m = arr2.length;

        int len = n+m;
        return get( (len-1)/2 , arr1, arr2);
    }

    public int get(int k, int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int curr1 = 0;
        int curr2 = 0;

        while (true) {
            int mid = k == 1? 1 : k >> 1;

            if (curr1 == n) {
                return arr2[curr2+k];
            }
            if (curr2 == m) {
                return arr1[curr1+k];
            }
            if (k == 0) {
                return Math.min(arr1[curr1], arr2[curr2]);
            }

            int next1 = Math.min(curr1+mid, n); //[)
            int next2 = Math.min(curr2+mid, m);

            if (arr1[next1-1] < arr2[next2-1]) {
                k -= next1 - curr1;
                curr1 = next1;
            } else {
                k -= next2 - curr2;
                curr2 = next2;
            }
        }


    }
}
