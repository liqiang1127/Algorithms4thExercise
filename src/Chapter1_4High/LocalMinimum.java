package Chapter1_4High;

public class LocalMinimum {
    //1.4.18 寻找数组的局部最小元素索引
    private static int LMIndex(int[] arr){
        int n = arr.length;
        if(n == 1)
            return 0;
        //主要是对首尾的情况要深入考虑一下
        if(arr[0] < arr[1])
            return 0;
        if(arr[n-1] < arr[n-2])
            return n-1;
        int l = 1, r = n-2;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1])
                return mid;
            else if(arr[mid] > arr[mid-1] && arr[mid+1] > arr[mid])
                r = mid-1;
            else if(arr[mid] < arr[mid-1] && arr[mid+1] < arr[mid])
                l = mid+1;
            else
                l = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,1,4};
        System.out.println(arr[LMIndex(arr)]);
    }
}
