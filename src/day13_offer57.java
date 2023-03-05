/**
 * https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof
 */
class Solution57 {
    //二分法+双指针
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] > (target >> 1)) {
                r = mid - 1;

            } else {
                l = mid;

            }
        }
        r = l + 1;
        while (r < nums.length && l >= 0) {
            if (nums[l] + nums[r] > target) l--;
            else if (nums[l] + nums[r] < target) r++;
            else return new int[]{nums[l], nums[r]};
        }
        return null;
    }

    //直接双指针（不如二分+双指针速度快
    public int[] twoSum2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] > target) r--;
            else if (nums[l] + nums[r] < target) l++;
            else return new int[]{nums[l], nums[r]};
        }

        return null;
    }
}

public class day13_offer57 {
    public static void main(String[] args) {
        Solution57 solution57 = new Solution57();
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        for (int i : solution57.twoSum(arr, target)) {
            System.out.print(i + "   ");
        }
        System.out.println();
        for (int i : solution57.twoSum2(arr, target)) {
            System.out.print(i + "   ");
        }
    }
}
