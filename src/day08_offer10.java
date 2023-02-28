import java.util.LinkedList;

class Solution08 {


    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int arr[] = new int[100];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }
        return arr[n];
    }


}

public class day08_offer10 {
    public static void main(String[] args) {
        Solution08 solution08 = new Solution08();
        System.out.println(solution08.fib(50));
    }
}
