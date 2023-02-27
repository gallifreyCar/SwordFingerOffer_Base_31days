class Solution53II {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i != nums[i]) return i;
            i++;
        }
        return nums.length;
    }
}

public class day04_offer53II {


    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(new Solution53II().missingNumber(arr));
    }

}
