import java.util.HashMap;

class Solution50 {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            int value = map.get(c) == null ? 0 : map.get(c);
            map.put(c, ++value);
        }
        for (char c : chars) {
            if (map.get(c) == 1) return c;
        }
        return ' ';
    }

    //这题只出现一次，用Boolean进行一次优化
    public char firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Boolean> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : chars) {
            if (map.get(c)) return c;
        }
        return ' ';
    }
}

public class day05_offer50 {


    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        System.out.println(solution50.firstUniqChar2("abaccdeff"));

    }
}
