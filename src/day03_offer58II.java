/**
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 */
class Solution58II {
    public String reverseLeftWords(String s, int n) {
        //    左闭右开
        String a = s.substring(n);
        String b = s.substring(0, s.length() - a.length());
        return a + b;
    }


}

public class day03_offer58II {
    public static void main(String[] args) {
        String s = "abdsgdg";
        System.out.println(new Solution58II().reverseLeftWords(s, 2));
    }
}
