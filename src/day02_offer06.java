
//Definition for singly-linked list.


class Solution06 {
    int arr1[] = new int[10000];

    int top = -1;
    int top2 = -1;

    public int[] reversePrint(ListNode head) {
        while (head != null) {
            arr1[++top] = head.val;
            head = head.next;

        }
        int arr2[] = new int[top + 1];
        while (top != -1) {
            arr2[++top2] = arr1[top--];
        }
        return arr2;
    }

}


public class day02_offer06 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        Solution06 solution = new Solution06();
        for (int a : solution.reversePrint(listNode)) {
            System.out.println(a);
        }

    }

}

