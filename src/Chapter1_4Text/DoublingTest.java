package Chapter1_4Text;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingTest {

    private static double timeTrial(int N){
        int max = 100000;
        int[] arr = new int[N];
        for (int i = 0; i < N ; i++) {
            arr[i] = StdRandom.uniform(-max, max);
        }
        Stopwatch sp = new Stopwatch();
        int cnt = ThreeSum.count(arr);
        return sp.elapsedTime();
    }

    public static void main(String[] args) {
        int N = 250;
        for (int i = 0 ; i < 5 ; i++ ) {
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N,time);
            N += N;
        }
    }
}
