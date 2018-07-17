package Chapter1_4High;

public class BinarySearchLow {
    public static int indexOf(int[] arr,int target){
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(target < arr[mid]) hi = mid - 1;
            else if(target > arr[mid]) lo = mid + 1;
            else {
                //找到了解，但是不直接返回
                int retIndex = mid;
                while(retIndex > 0 && arr[retIndex] == arr[retIndex-1])
                    retIndex --;
                return retIndex;
            }
        }
        return -1;
    }

}
