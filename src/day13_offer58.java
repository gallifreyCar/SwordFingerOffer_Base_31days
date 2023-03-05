/**
 * https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
class Solution58 {
    public String reverseWords(String s) {
        String[] strArr = s.trim().split("\\s+");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strArr.length - 1; i >= 0; i--) {
            stringBuilder.append(strArr[i]);
            if (i != 0) stringBuilder.append(" ");
        }


        return stringBuilder.toString();
    }
}

public class day13_offer58 {
    public static void main(String[] args) {
        Solution58 solution58 = new Solution58();
        System.out.println(solution58.reverseWords("  hello     world!  "));
    }

}
