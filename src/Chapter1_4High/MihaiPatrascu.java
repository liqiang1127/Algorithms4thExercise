package Chapter1_4High;

import java.util.Arrays;

public class MihaiPatrascu {
    // 1.4.22
    private static int fibSearch(int[] arr,int target){
        //构建斐波那契数组
        int n = arr.length;
        int[] fib = new int[100];

        //只有一个元素
        if(arr.length == 1)
            return arr[0] == target ? 0 : -1;

        fib[0] = 1;
        fib[1] = 1;

        int pos = 2;
        //找到合适的fib数
        for ( ; pos < fib.length; pos++) {
            fib[pos] = fib[pos-1] + fib[pos-2];
            if(fib[pos] >= arr.length)
                break;
        }

        //构建fib数组
        Arrays.sort(arr);
        int[] fibArr = new int[fib[pos]];

        for (int i = 0; i < fib[pos]; i++){
            if(i < n)
                fibArr[i] = arr[i];
            else
                fibArr[i] = arr[n-1];
        }


        //fib查找 [l,r]
        int l = 0;
        int r = fib[pos] - 1;

        while ( l <= r ){
            //处理边界
            //最后区间为1 即 l == r的时候， pos-1可能越界。
            if(l == r && fibArr[l] == target)
                return l;
            else if(l == r && fibArr[l] != target)
                break;

            //寻找mid
            int mid = l + fib[pos-1] - 1;
            if(fibArr[mid] == target){
                if(mid < n)
                    return mid;
                else
                    return n - 1;
            }

            if(fibArr[mid] > target ){
                r = mid;
                pos -= 1;
            }else{
                l = mid + 1;
                pos -= 2;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7};
//        for (int i = 0; i < arr.length ; i++) {
//            System.out.println(fibSearch(arr,i));
//        }
        System.out.println(fibSearch(arr,0));
    }
}
