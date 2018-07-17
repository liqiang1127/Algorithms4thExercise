package Chapter1_4High;

public class FarestDistance {
    // 1.4.17
    private static int farestDistance(int[] arr){
        int max = arr[1] > arr[0] ? arr[1]:arr[0];
        int min = arr[1]+arr[0] - max;
        for (int i=2; i<arr.length ; i++){
            if(arr[i] > max)
                max = arr[i];
            if(arr[i] < min)
                min = arr[i];
        }
        return max - min;
    }

    public static void main(String[] args) {
        int[] arr = {1,12,3,1,10};
        System.out.println(farestDistance(arr));
    }
}
