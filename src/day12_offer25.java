class Solution25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pointOne = l1;
        ListNode pointTwo = l2;
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (pointOne != null || pointTwo != null) {
            if (pointOne == null) {
                temp.next = pointTwo;
                break;
            }
            if (pointTwo == null) {
                temp.next = pointOne;
                break;
            }

            if (pointOne.val <= pointTwo.val) {
                temp.next = pointOne;
                temp = temp.next;
                pointOne = pointOne.next;
            } else {
                temp.next = pointTwo;
                temp = temp.next;
                pointTwo = pointTwo.next;
            }
        }

        return head.next;
    }
}

public class day12_offer25 {
    public static void main(String[] args) {
        int[] arrA = {1, 2, 4};
        int[] arrB = {1, 3, 4};
        ListNode headA = ListBuilder.build(arrA);
        ListNode headB = ListBuilder.build(arrB);
        Solution25 solution25 = new Solution25();
        System.out.println(headA);
        System.out.println(headB);
        System.out.println(solution25.mergeTwoLists(headA, headB));
    }
}
