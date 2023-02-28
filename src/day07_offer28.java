import java.util.LinkedList;

class Solution28 {

    //迭代法
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        //队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 一开始放入两个根 分别从左，从右各取一个节点放入队列
        // 这样相邻的两个节点是相等的 每次取两个出来作比较
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode leftTreeNode = queue.poll();
            TreeNode rightTreeNode = queue.poll();

            //左右皆为空 跳过这次循环
            if (leftTreeNode == null && rightTreeNode == null) {
                continue;
            }
            //只有一个为空 肯定不对称
            if (leftTreeNode == null || rightTreeNode == null) {
                return false;
            }
            if (leftTreeNode.val != rightTreeNode.val) {
                return false;
            }
            //比较外侧两边
            queue.offer(leftTreeNode.left);
            queue.offer(rightTreeNode.right);
            //比较内侧两边
            queue.offer(leftTreeNode.right);
            queue.offer(rightTreeNode.left);
        }
        return true;
    }

    //递归法
    //递归法相比迭代法节省了一个队列
    public boolean isSymmetric2(TreeNode root) {
        return root == null ? true : check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        //如果左右节点都为空 返回真
        if (left == null && right == null) {
            return true;
        }
        //如果只有一个节点为空，或者左右节点值不相等，返回false
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        //如果左右节点值相等，检查下一层 左树左和右树右（外侧） 左树右和右树左（内侧）
        return check(left.left, right.right) && check(left.right, right.left);
    }


}

public class day07_offer28 {


    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, -1, -1, 3};
        TreeNode root = TreeBuilder.build(arr);
        Solution28 solution28 = new Solution28();
        System.out.println(solution28.isSymmetric(root));
        System.out.println(solution28.isSymmetric2(root));

    }


}
