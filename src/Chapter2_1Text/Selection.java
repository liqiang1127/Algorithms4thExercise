package Chapter2_1Text;

import edu.princeton.cs.algs4.StdIn;

public class Selection{
    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n ; j++) {
                if(less(a[j], a[min]))
                    min = j;
            }
            exchange(a, min, i);
        }
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exchange(Comparable[] a,int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static boolean isSorted(Comparable[] a){
        for (int i = 1 ; i < a.length ; i++) {
            if(less(a[i], a[i-1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
