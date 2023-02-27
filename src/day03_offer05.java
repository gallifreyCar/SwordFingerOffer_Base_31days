
class Solution05 {
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
}

public class day03_offer05 {


    public static void main(String[] args) {
        Solution05 solution05 = new Solution05();
        System.out.println(solution05.replaceSpace("hello world !"));
    }
}
