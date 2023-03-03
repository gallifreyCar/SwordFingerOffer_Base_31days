import java.awt.*;

/**
 * https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
class Solution18 {
    //加多一个头节点再去遍历
    public ListNode deleteNode(ListNode head, int val) {
        ListNode Point = new ListNode(-1);
        ListNode temp = Point;
        Point.next = head;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
        }
        return Point.next;
    }

    //对头节点做特殊判断
    public ListNode deleteNode2(ListNode head, int val) {

        if (head.val == val) return head.next;

        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
        }
        return head;
    }
}

public class day11_offer18 {

    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        int arr[] = {4, 5, 1, 9};
        ListNode head = new ListNode(-1000);
        ListNode temp = head;
        for (int i = 0; i < arr.length; i++) {
            ListNode listNode = new ListNode(arr[i]);
            temp.next = listNode;
            temp = temp.next;
        }

        System.out.println(head.next);
        System.out.println(solution18.deleteNode(head.next, 4));
        System.out.println(solution18.deleteNode2(head.next, 4));
    }


}
