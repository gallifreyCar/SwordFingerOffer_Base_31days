import java.util.Arrays;

class Solution61 {
    public boolean isStraight(int[] nums) {
        int skip = 0;
        Arrays.sort(nums);
        int j = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                skip++;
                continue;
            }
            if (nums[i] == nums[i + 1]) return false;
            while (skip > 0 && nums[i] + j != nums[i + 1]) {
                skip--;
                j++;
            }
            if (nums[i] + j != nums[i + 1]) return false;
            j = 1;
        }
        return true;

    }


    //直接用除了鬼牌（0）以外的最大牌减去最小牌 max-min<0则可以构成顺子
    public boolean isStraight2(int[] nums) {
        int skip = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) skip++;
            else if (nums[i] == nums[i + 1]) return false;
        }
        return nums[nums.length - 1] - nums[skip] < 5;

    }
}

public class day16_offer61 {
    public static void main(String[] args) {
        Solution61 solution61 = new Solution61();
        int[] nums = {9, 0, 6, 0, 10};
        System.out.println(solution61.isStraight(nums));
        System.out.println(solution61.isStraight2(nums));
    }
}

