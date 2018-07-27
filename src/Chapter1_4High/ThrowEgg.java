package Chapter1_4High;

public class ThrowEgg {
    private static int throwEgg1(int[] arr){
        //O(logN)
        //二分查找
        int n = arr.length;
        int lo = 0, hi = n-1;

        //在[lo,hi]中进行二分查找
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(mid == 0)
                return mid;

            if(arr[mid-1] == 0 && arr[mid] == 1)
                return mid;

            if(arr[mid] == 0)
                lo = mid + 1;
            if(arr[mid-1] == 1)
                hi = mid - 1;
        }
        return -1;
    }

    private static int throwEgg2(int[] arr){
        //O(logF)
        //先 1 2 4 8 ... 2^k 直到 2^k >= f
        //再在[2^(k-1),2^k]之间二分查找

        //找 k
        int k = 0;
        //两个终止条件 1.越界 2.== 1
        while(power(2,k)-1 < arr.length && arr[power(2,k)-1] == 0)
            k++;

        if(k == 0)
            //第0层就碎了
            return 0;

        //在区间内二分查找
        int lo = power(2, k-1)-1;
        int hi = power(2,k)-1 < arr.length ? power(2,k)-1 : arr.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(mid == lo)
                return lo;
            if(arr[mid-1] == 0 && arr[mid] == 1)
                return mid;
            if(arr[mid] == 0)
                lo = mid + 1;
            if(arr[mid-1] == 1)
                hi = mid - 1;
        }

        return -1;
    }

    //计算 base的exp次方 二分快速幂
    private static int power(int base,int exp){
        int memo = 1;
        if (exp == 0)
            return 1;
        while (exp > 1){
            if(exp % 2 == 0){
                base *= base;
                exp /= 2;
            }else{
                memo *= base;
                exp --;
            }
        }
        return base * memo;
    }


    public static void main(String[] args) {
        int n = 100, f = 66;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if(i < f)
                arr[i] = 0;
            else
                arr[i] = 1;
        }

        System.out.println(throwEgg1(arr));
        System.out.println(throwEgg2(arr));
    }
}
