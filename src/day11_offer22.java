import java.util.HashMap;

/**
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
class Solution22 {

    //哈希表
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode temp = head;
        HashMap<Integer, ListNode> map = new HashMap();

        int i = 1;
        while (temp != null) {
            map.put(i++, temp);
            temp = temp.next;
        }
        return map.get(i - k);
    }


    //双指针
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode former = head;
        ListNode latter = head;
        for (int i = 0; i < k; i++) {
            former = former.next;
        }
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }

        return latter;
    }
}

public class day11_offer22 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListBuilder.build(arr);
        System.out.println(head);
        Solution22 solution22 = new Solution22();
        System.out.println(solution22.getKthFromEnd(head, 2));
        System.out.println(solution22.getKthFromEnd2(head, 2));
    }
}
