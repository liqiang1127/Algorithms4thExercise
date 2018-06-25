package Chapter1_4Text;

import Chapter1_1Text.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class TwoSumFast {
    //twoSum的快速实现版 O(NlgN)
    // 有些情况是不行的 -10 -9 -8 -8 -4 0 3 7 9 9
    // -1 0 0 2
    public static int count(int[] a){
        int cnt = 0;
        Arrays.sort(a);
        //利用二分查找
        int n = a.length;
        for (int i = 0; i < n ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n ; i++) {
            if(BinarySearch.rank(-a[i],a) > i)
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = StdRandom.uniform(-n, n);
        }


        int[] arr2 = arr1.clone();

        Stopwatch sp1 = new Stopwatch();
        System.out.println(TwoSum.count(arr1));
        System.out.println(sp1.elapsedTime());
        Stopwatch sp2 = new Stopwatch();
        System.out.println(TwoSumFast.count(arr2));
        System.out.println(sp2.elapsedTime());
    }
}
