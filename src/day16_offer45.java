import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

class Solution45 {
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        int i = 0;
        for (int num : nums) {
            String numStr = String.valueOf(num);
            strings[i++] = numStr;
        }
        Arrays.sort(strings, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }


}

public class day16_offer45 {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        Solution45 solution45 = new Solution45();
        System.out.println(solution45.minNumber(nums));
    }
}
