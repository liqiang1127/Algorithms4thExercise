package Chapter1_4Text;

import edu.princeton.cs.algs4.StdRandom;

public class ThreeSum {
    public static int count(int[] arr){
        int cnt = 0;
        int n = arr.length;
        for (int i = 0; i < n-2 ; i++)
            for (int j = 0; j < n-1 ; j++)
                for (int k = 0; k < n ; k++)
                    if(arr[i] + arr[j] + arr[k] == 0)
                        cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        int n = 1000;
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++)
            arr[i] = StdRandom.uniform(-1000,1000);
        Stopwatch sp = new Stopwatch();
        int count = ThreeSum.count(arr);
        double time = sp.elapsedTime();
        System.out.println(count +" ---- " +time);
    }
}
