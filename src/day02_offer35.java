import java.util.HashMap;
import java.util.Map;

class Solution35 {
    public Node copyRandomList(Node head) {

        //保存head值
        Node save = head;
        //用哈希表保存节点
        Map<Node, Node> map = new HashMap();
        //尾插法建立链表
        Node newHead = new Node(0);
        Node tail = newHead;
        while (head != null) {
            tail.next = new Node(head.val);
            ;
            tail = tail.next;
            map.put(head, tail);
            head = head.next;

        }

        head = save;
        while (head != null) {
            map.get(head).random = map.get(head.random);
            head = head.next;
        }

        newHead = newHead.next;
        return newHead;


    }


}

public class day02_offer35 {
    public static void main(String[] args) {
//        7 13 11 10 1
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);

        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;
        node1.next = null;

        node7.random = null;
        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;

        System.out.println(node7);
        Solution35 solution35 = new Solution35();
        System.out.println(solution35.copyRandomList(node7));
    }
}
