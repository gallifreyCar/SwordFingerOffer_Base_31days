

class Solution53 {
    public int search(int[] nums, int target) {
        //空数组返回 0
        if (nums.length == 0) return 0;

        //先二分找到最先出现的target的索引位置
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        //找不到target返回 0
        if (nums[l] != target) return 0;

        //统计出现次数
        int cont = 1;
        while (l < nums.length - 1) {
            if (nums[l] == nums[++l]) cont++;
            else break;
        }
        return cont;


    }

}

public class day04_offer53 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 3,};
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.search(arr, 2));

    }
}