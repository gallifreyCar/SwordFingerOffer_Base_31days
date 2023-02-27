import java.util.HashSet;
import java.util.Set;

class Solution03 {
    public int findRepeatNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return nums[i];
            }
        }

        return -1;
    }


    public int findRepeatNumber2(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    //索引重排 让索引和数组一一对应
    public int findRepeatNumber3(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            //排好序跳过
            if (i == nums[i]) {
                i++;
                continue;
            }
            //要排序的位置已经有数了，说明重复了
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            //如果索引i和nums[i]数字不相等，就把nums[i]调到它应该去的位置nums[nums[i]]=nums[i]）
            //交换
            int temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;


        }
        return -1;
    }
}

public class day04_offer03 {
    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();
        int[] input = {2, 3, 1, 0, 2, 5, 3};

        System.out.println(solution03.findRepeatNumber(input));
        System.out.println(solution03.findRepeatNumber2(input));
        System.out.println(solution03.findRepeatNumber3(input));
    }
}
