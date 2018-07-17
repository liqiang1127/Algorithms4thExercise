package Chapter1_4High;

import java.util.Arrays;

public class FourSum {
    //O(N^3logN)
    //其实这种方法不对，需要改造一下BinarySearch，要让元素相同返回最小的索引才行。
    private static int fourSum (int[] arr){
        int cnt = 0;
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = 0; i < n-1; i++){
            for (int j = i+1; j < n-2; j++){
                for (int k = j+1 ; k < n-1; k++){
                    int target = 0 - arr[i] - arr[j] - arr[k];
                    int index = BinarySearchLow.indexOf(arr, target);
                    if(index == -1)
                        continue;
                    if(arr[index] == arr[k]){
                        index = k+1;
                        while(index < arr.length && arr[index] == arr[index-1]){
                            cnt++;
                            index++;
                        }
                    }else if(index > k){
                        cnt++;
                        index++;
                        while(index < arr.length && arr[index] == arr[index-1]){
                            cnt++;
                            index++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {-4,0,2 ,2,2,2};
        System.out.println(FourSum.fourSum(arr));
    }
}
