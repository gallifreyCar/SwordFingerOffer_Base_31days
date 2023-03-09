import java.util.Arrays;

/**
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof
 */
class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);

        int[] res = Arrays.copyOfRange(arr, 0, k);
        return res;
    }


}

public class day17_offer40 {
    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        int[] arr = {3, 2, 1};

        for (int i : solution40.getLeastNumbers(arr, 2)) {
            System.out.println(i);
        }

    }
}
