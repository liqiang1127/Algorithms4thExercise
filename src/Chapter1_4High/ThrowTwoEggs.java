package Chapter1_4High;

public class ThrowTwoEggs {
    private static int throwTwoEggs1(int[] arr){
        //时间复杂度 2/`n /`表示根号
        //先以/`n为步长，确定区间[(k-1)/`n,k/`n]，再在区间内依次搜索。
        int step = getStep(arr.length);
        int k = 1;
        while(k * step < arr.length && arr[k*step] == 0)
            k++;

        //确定区间
        int lo = (k-1)*step;
        int hi = k * step < arr.length ? k * step : arr.length-1;
        while(lo <= hi){
            if(arr[lo] == 1)
                break;
            else
                lo++;
        }
        return lo;
    }

    private static int getStep(int n){
        int ret = 1;
        while(ret * ret < n)
            ret++;
        return ret;
    }

    private static int throwTowEggs2(int[] arr){
        //利用0,1,3,6,10....
        //通项公式是等差数列前n项和
        int lo = 0, step = 1;
        int hi = lo + step;
        while(true){
            if(arr[hi] == 1){
                break;
            }
            step ++;
            lo = hi;
            hi = lo + step < arr.length ? lo + step : arr.length - 1;
        }

        while(lo <= hi){
            if(arr[lo] == 1)
                break;
            else
                lo++;
        }

        return lo;
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

        System.out.println(throwTwoEggs1(arr));
        System.out.println(throwTowEggs2(arr));
    }
}
