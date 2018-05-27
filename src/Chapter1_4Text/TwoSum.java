package Chapter1_4Text;

public class TwoSum {
    //暴力解法
    public static int count(int[] a){
        int count = 0;
        int n = a.length;
        for (int i = 0; i < n ; i++) {
            for (int j = i+1; j < n ; j++) {
                if(a[i] + a[j] == 0)
                    count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 测试略了
    }
}
