package Chapter1_4High;

import java.util.Arrays;

public class StaticSETofInts {
    // 1.4.21
    private int[] a;
    public StaticSETofInts(int[] keys){
        a = new int[keys.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }

    public boolean contains(int key){
        return indexOfInt(key) != -1;
    }

    private int indexOfInt(int key){
        //二分查找 [lo,hi]
        int lo = 0;
        int hi = a.length-1;
        while ( lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(a[mid] == key)
                return mid;
            if(a[mid] < key)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        StaticSETofInts set = new StaticSETofInts(a);
        System.out.println(set.contains(1));
        System.out.println(set.contains(5));
    }
}
