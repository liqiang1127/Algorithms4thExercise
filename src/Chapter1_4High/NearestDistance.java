package Chapter1_4High;

import java.util.Arrays;

public class NearestDistance {
    // 1.4.16
    private static int nearestPair(int[] arr){
        Arrays.sort(arr);
        int n = arr.length;
        int distance = arr[1] - arr[0];
        for (int i = 2; i < n; i++){
            if(arr[i] - arr[i-1] < distance)
                distance = arr[i] - arr[i-1];
        }
        return distance;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,2,100,200};
        System.out.println(nearestPair(arr));
    }
}
