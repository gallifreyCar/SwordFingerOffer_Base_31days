import java.util.HashMap;

/**
 * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 */

class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap();

        int resMax = 0;
        for (int i = 0; i < arr.length; i++) {


            if (hashMap.containsKey(arr[i])) {
                i = hashMap.get(arr[i]) + 1;
                hashMap.clear();
            }
            hashMap.put(arr[i], i);
            resMax = Math.max(resMax, hashMap.size());


        }
        return resMax;
    }

    //进一步优化，不需要每次从第一个重复字符开始重新遍历
    //只需要更新左边界到第一个重复字符后一个，把滑动数组左边的字符都弹出
    public int lengthOfLongestSubstring2(String s) {
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap();
        int left = 0;
        int resMax = 0;
        for (int i = 0; i < arr.length; i++) {


            if (hashMap.containsKey(arr[i])) {
                left = Math.max((hashMap.get(arr[i]) + 1), left);
            }
            hashMap.put(arr[i], i);
            resMax = Math.max(i - left + 1, resMax);


        }
        return resMax;
    }

}

public class day10_offer48 {

    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        System.out.println(solution48.lengthOfLongestSubstring2("abba"));
    }
}
