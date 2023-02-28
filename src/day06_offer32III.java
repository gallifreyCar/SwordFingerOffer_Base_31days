import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution32III {


    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList();
        if (root == null) {
            return res;
        }
        //队列
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        //BFS 层序遍历
        int count = 1;
        while (!list.isEmpty()) {

            LinkedList<Integer> row = new LinkedList<>();
            //记录层数

            //用for循环和队列长度实现分层
            for (int i = list.size(); i > 0; i--) {
                TreeNode treeNode = list.poll();
                //分层添加 奇数层加到队尾正序
                if (count % 2 != 0) {
                    row.addLast(treeNode.val);
                } else {
                    //偶数层加到队头逆序
                    row.addFirst(treeNode.val);
                }

                if (treeNode.left != null) {
                    list.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    list.offer(treeNode.right);
                }

            }
            count++;

            res.add(row);
        }

        return res;
    }


}

public class day06_offer32III {
    public static void main(String[] args) {

        int[] arr = {3, 9, 20, -1, -1, 15, 7};
        TreeNode root = TreeBuilder.build(arr);
        System.out.println(root);
        Solution32III solution32III = new Solution32III();
        System.out.println(solution32III.levelOrder(root));

    }
}
