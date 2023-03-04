public class ListBuilder {
    static ListNode build(int arr[]) {
        ListNode listNode = new ListNode(-1);
        ListNode temp = listNode;
        for (int num : arr) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        listNode.next.end = temp;
        return listNode.next;
    }
}
