package Chapter1_4Low;

import java.util.Arrays;

public class ThreeSum {
    //1.4.2
    public static int count(int[] arr){
       int count = 0;
       //先排序 保证大小
       Arrays.sort(arr);
       int n = arr.length;
        for (int i = 0; i < n-2 ; i++)
            for (int j = 0; j < n-1 ; j++)
                for (int k = 0; k < n ; k++)
                    //两个小的数字之和等于最大的数字的相反数
                    if(arr[i] + arr[j] == -arr[k])
                        count++;
       return count;
    }
}
