/**
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 */

class Solution21 {
    public int[] exchange(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        for (int num : nums) {
            if (num % 2 != 0) res[i++] = num;
            else res[j--] = num;
        }

        return res;
    }
}

public class day13_offer21 {


    public static void main(String[] args) {
        int arr[] = {2, 4, 6};
        Solution21 solution21 = new Solution21();
        for (int i : solution21.exchange(arr)) {
            System.out.println(i);
        }
    }
}
