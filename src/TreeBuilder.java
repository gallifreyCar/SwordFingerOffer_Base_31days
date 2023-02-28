import java.util.*;

public class TreeBuilder {


    static TreeNode createTree(LinkedList<Integer> list) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(list.poll());
        queue.offer(root);
        while (!list.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (!list.isEmpty() && list.getFirst() == -1) {
                list.poll();
                treeNode.left = null;
            } else if (!list.isEmpty()) {
                TreeNode left = new TreeNode(list.poll());
                treeNode.left = left;
                queue.offer(left);
            }

            if (!list.isEmpty() && list.getFirst() == -1) {
                list.poll();
                treeNode.right = null;
            } else if (!list.isEmpty()) {
                TreeNode right = new TreeNode(list.poll());
                treeNode.right = right;
                queue.offer(right);
            }


        }

        return root;

    }

    static TreeNode build(int arr[]) {
        return createTree(ArraysToList(arr));
    }

    public static LinkedList ArraysToList(int arr[]) {
        LinkedList list = new LinkedList();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {
        int arr[] = {4, 2, 3, 4, 5, 6, 7, 8, 9};
        int arr2[] = {3, 9, 20, -1, -1, 15, 7};
        TreeNode A = TreeBuilder.build(arr);
        TreeNode B = TreeBuilder.build(arr2);
        System.out.println(A);
        System.out.println(B);

    }
}
