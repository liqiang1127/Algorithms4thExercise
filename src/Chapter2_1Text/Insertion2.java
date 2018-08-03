package Chapter2_1Text;

import edu.princeton.cs.algs4.StdIn;

public class Insertion2 {

    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i = 1; i < n ; i++) {
            Comparable ch = a[i];
            int j = i;
            for (; j > 0 ; j--) {
                if(less(ch, a[j-1]))
                    a[j] = a[j-1];
                else
                    break;
            }
            a[j] = ch;
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
