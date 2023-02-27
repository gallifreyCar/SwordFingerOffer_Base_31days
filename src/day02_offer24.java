
// Definition for singly-linked list.


class Solution24 {
    //    头插法
    public ListNode reverseList(ListNode head) {
        ListNode anotherHead = new ListNode(0);
        ListNode tail;

        while (head != null) {

            tail = new ListNode(head.val);
            tail.next = anotherHead.next;
            anotherHead.next = tail;
            head = head.next;
        }

        return anotherHead.next;
    }


    //  双指针
    public ListNode reverseList2(ListNode head) {
        ListNode current = head;
        ListNode next = null;
        ListNode pre = null;

        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }


}

public class day02_offer24 {
    public static void main(String[] args) {

        int i = 5;
        ListNode listNode = new ListNode(i);

        ListNode tail = new ListNode(--i);
        listNode.next = tail;
        while (i != 0) {
            tail.next = new ListNode(--i);
            tail = tail.next;

        }
        System.out.println(listNode);

        Solution24 solution24 = new Solution24();
        System.out.println(solution24.reverseList(listNode));
        System.out.println(solution24.reverseList2(listNode));

    }


}

