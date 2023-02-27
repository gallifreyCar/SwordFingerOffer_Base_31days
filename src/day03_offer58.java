
class Solution58 {
    public String reverseLeftWords(String s, int n) {
        //    左闭右开
        String a = s.substring(n);
        String b = s.substring(0, s.length() - a.length());
        return a + b;
    }


}

public class day03_offer58 {
    public static void main(String[] args) {
        String s = "abdsgdg";
        System.out.println(new Solution58().reverseLeftWords(s, 2));
    }
}
