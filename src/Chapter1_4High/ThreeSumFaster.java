package Chapter1_4High;

import java.util.Arrays;

public class ThreeSumFaster {
    //1.4.15 双指针对撞
    private static int threeSumFaster(int[] arr){
        Arrays.sort(arr);
        int cnt = 0;
        int n = arr.length;
        for (int i = 0; i < n - 2; i ++ ){
            int l = i+1;
            int r = n-1;
            while (l < r){
                if(arr[l] + arr[r] == -arr[i]){
                    //去重
                    while (l<r && arr[l] == arr[l+1])
                        l++;
                    while (l<r && arr[r] == arr[r-1])
                        r--;
                    l++;
                    r--;
                }else if(arr[l] + arr[r] > -arr[i]){
                    r--;
                }else {
                    l++;
                }
            }
        }
        return cnt;
    }
}
