
import java.util.*;

class Solution32 {


    public int[] levelOrder(TreeNode root) {

        int[] b = new int[0];
        if (root == null) {
            return b;
        }
        int count = 0;
        int arr[] = new int[1000];

        //队列
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        //BFS 层序遍历
        while (!list.isEmpty()) {
            TreeNode treeNode = list.poll();
            arr[count++] = treeNode.val;
            if (treeNode.left != null) {
                list.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                list.offer(treeNode.right);
            }
        }

        b = Arrays.copyOf(arr, count);

        return b;
    }


}

public class day06_offer32 {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        TreeNode root = TreeBuilder.build(arr);

        System.out.println(root);
        Solution32 solution32 = new Solution32();
        int[] res = solution32.levelOrder(root);
        for (int num : res) {
            System.out.println(num);
        }

    }

}
