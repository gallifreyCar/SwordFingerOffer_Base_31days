class Solution42 {
    public int maxSubArray(int[] nums) {
        //当前区间内的价值
        int nowLandR[] = new int[nums.length];
        nowLandR[0] = nums[0];
        //记录子区间最大和
        int max = nowLandR[0];
        for (int i = 1; i < nums.length; i++) {

            nowLandR[i] = Math.max(nums[i], nowLandR[i - 1] + nums[i]);
            max = Math.max(max, nowLandR[i]);
        }
        return max;
    }

    //进一步优化
    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {

            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}

public class day09_offer42 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution42 solution42 = new Solution42();
        System.out.println(solution42.maxSubArray(nums));
        System.out.println(solution42.maxSubArray2(nums));
    }
}
