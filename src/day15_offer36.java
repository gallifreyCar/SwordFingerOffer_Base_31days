import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

class Solution36 {

    //用hashmap和链表简单实现
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;

        HashMap<Integer, TreeNode> map = new HashMap();
        LinkedList<Integer> list = new LinkedList();
        dfs(root, map, list);
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            map.get(list.get(i)).right = map.get(list.get(i + 1));
            map.get(list.get(i + 1)).left = map.get(list.get(i));
        }
        map.get(list.getFirst()).left = map.get(list.getLast());
        map.get(list.getLast()).right = map.get(list.getFirst());

        return map.get(list.get(0));


    }

    void dfs(TreeNode root, HashMap map, LinkedList<Integer> list) {
        if (root == null) return;
        map.put(root.val, root);
        list.add(root.val);
        if (root.left != null) dfs(root.left, map, list);
        if (root.right != null) dfs(root.right, map, list);

    }


    //中序遍历直接修改树优化
    TreeNode head;

    TreeNode previous;

    public TreeNode treeToDoublyList2(TreeNode root) {
        if (root == null) return null;

        dfs(root);
        head.left = previous;
        previous.right = head;

        return head;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (head == null) {
            head = root;
            previous = head;
        } else {
            previous.right = root;
            root.left = previous;
            previous = root;
        }

        dfs(root.right);

    }


}

public class day15_offer36 {

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 1, 3};
        TreeNode root = TreeBuilder.build(arr);
        System.out.println(root);

        Solution36 solution36 = new Solution36();
        TreeNode res = solution36.treeToDoublyList2(root);

        System.out.println(res.val + "\n" + res.left.val + "\n" + res.right.val);
    }
}
