
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
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        System.out.println(treeNode1);
        Solution32 solution32 = new Solution32();
        int[] res = solution32.levelOrder(treeNode1);
        for (int num : res) {
            System.out.println(num);
        }

    }

}
