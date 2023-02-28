import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution32II {


    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList();
        if (root == null) {
            return res;
        }
        //队列
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        //BFS 层序遍历
        while (!list.isEmpty()) {

            List<Integer> row = new LinkedList<>();
            //用for循环和队列长度实现分层
            for (int i = list.size(); i > 0; i--) {
                TreeNode treeNode = list.poll();
                row.add(treeNode.val);

                if (treeNode.left != null) {
                    list.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    list.offer(treeNode.right);
                }
            }

            res.add(row);
        }

        return res;
    }


}

public class day06_offer32II {
    public static void main(String[] args) {
        int[] arr = {3, 9, 20, -1, -1, 15, 7};
        TreeNode root = TreeBuilder.build(arr);

        System.out.println(root);
        Solution32II solution32II = new Solution32II();
        System.out.println(solution32II.levelOrder(root));

    }
}
