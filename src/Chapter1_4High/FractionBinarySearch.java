package Chapter1_4High;

import java.util.Arrays;

public class FractionBinarySearch {
    //分数的二分查找

    /**
     * 程序员朋友都知道在我们的日常开发中，如果需要判断两个整数是否相等，可以使用"=="，
     * 但如果是判断两个分数是否相等，一般是小于某个数。
     * 这是因为在现有的计算机体系结构下，浮点数的精度是没有保障的，对于差别足够小的两个浮点数，我们一般只能认为它们是相等的，而无论他们是否真正相等。
     * 而对于一般情况，就是你看的教程说的，用一个足够小的数来比较他们的差值，如果差值小于这个足够小的数，
     * 如我上文所述，我们就只能接受一个事实就是，其实我们没法知道他们是不是相等，所以只能就当他们相等吧。
     * 这里的一个小问题是，这个足够小的数怎么定义？这个一般是个经验值，小数点后面七八个零一般认为就差不多了。
     * 根据书中的提示，将二分查找中判断相等的条件改为两个数的差小于等于 1/N2。
     *
     * @param arr
     * @param target
     * @return
     */

    private static int fractionBinarySearch(double[] arr, double target){
        int n = arr.length;
        double threshold = 1 / (n * n);

        Arrays.sort(arr);

        //[lo,hi]
        int lo = 0, hi = n - 1;

        while( lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(Math.abs(arr[mid] - target ) <= threshold)
                return mid;
            if(target - arr[mid] > 0)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        double[] fractions = {1.0/2.0,2.0/3.0,3.0/4.0,4.0/5.0,5.0/6.0};
        Arrays.sort(fractions);
        int index = fractionBinarySearch(fractions, 5.0/6.0);

        System.out.print("4.0/5.0 在第" + index + "个");
    }
}
