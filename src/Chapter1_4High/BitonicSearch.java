package Chapter1_4High;

public class BitonicSearch {
    // 1.4.20 双调查找
    // 先通过二分的方式找到最大值的索引，再分为一个单增和一个单减的区间，分别用二分查找。
    private static int bitonicSearch(int[] arr, int target){
        int max_index = find_max_index(arr);
        //如果是最大的元素 直接返回就行了
        if(arr[max_index] == target)
            return max_index;
        int iUP = binarySearchUP(arr,0,max_index,target);
        if(iUP != -1)
            return iUP;
        int iDOWN = binarySearchDown(arr, max_index+1, arr.length, target);
        if(iDOWN != -1)
            return iDOWN;
        return -1;
    }

    private static int find_max_index(int[] arr){
        //双调数组最大值一定在数组的中间
        //不需要像localMinimum一样,对边界特殊考虑了。
        int l = 0;
        int h = arr.length - 1;
        //[l,h]中寻找最大值
        while ( l <= h){
            int mid = l + (h - l) / 2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(arr[mid+1] > arr[mid-1])
                l = mid + 1;
            else
                h = mid - 1;
        }
        return -1;
    }

    // 在[start,end)这个递增的数组中进行二分查找
    private static int binarySearchUP(int[] arr,int start, int end,int target){
        int l = start;
        int r = end - 1;
        while ( l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid] == target)
                return mid;
            if(arr[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    // 在[start,end)这个递减的数组中进行二分查找
    private static int binarySearchDown(int[] arr,int start, int end, int target){
        int l = start;
        int r = end - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid] == target)
                return mid;
            if(arr[mid] > target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return  -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,2,1};
        System.out.println(bitonicSearch(arr,4));
    }
}
