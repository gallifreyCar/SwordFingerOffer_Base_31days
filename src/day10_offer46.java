import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
class Solution46 {
    int left = -1;
    LinkedList<Integer> list = new LinkedList<>();
    int count = 0;

    public int translateNum(int num) {
        while (num > 0) {
            list.push(num % 10);
            num /= 10;
        }
        recursion(list, left);
        return count;
    }

    //dfs 递归法 走出叶子节点 count++
    void recursion(LinkedList<Integer> list, int left) {
        if (left == list.size() - 1) {
            count++;
            return;
        }
        //取1个数
        recursion(list, left + 1);
        // 取2个数
        if (left + 2 <= list.size() - 1 && (list.get(left + 1) * 10 + list.get(left + 2) <= 25) && list.get(left + 1) != 0)
            recursion(list, left + 2);
    }


    //有条件的青蛙跳台阶
    public int translateNum2(int num) {

        int right = num % 10;      //  8 5 2 2 1
        int left;              //  5 2 2 1
        int temp;            //  58 25 22 12 1
        int newS;      //f(n)
        int nowS = 1; // f(n-1)
        int preS = 1; // f(n-2)
        while (num != 0) {
            num /= 10;
            left = num % 10;
            temp = left * 10 + right;
            newS = (temp >= 10 && temp <= 25) ? preS + nowS : nowS;
            preS = nowS;
            nowS = newS;
            right = left;

        }
        return nowS;
    }


}


public class day10_offer46 {


    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int nums = 26;
        System.out.println(solution46.translateNum(nums));
        System.out.println(solution46.translateNum2(nums));

    }

}