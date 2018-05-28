package Chapter1_4Text;

import Chapter1_1Text.BinarySearch;

public class ThreeSumFast {
    //基于BinarySearch的实现 O(N^2lgN)
    public static int count(int[] a){
        int count = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(BinarySearch.rank(-a[i]-a[j], a) > j)
                    count++;
            }
        }
        return count;
    }
}
