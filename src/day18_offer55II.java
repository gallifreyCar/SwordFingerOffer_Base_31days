/**
 * https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof
 */

class Solution55II {


    public boolean isBalanced(TreeNode root) {

        return recursion(root) != -1;
    }

    //利用平衡二叉树的深度=左右子树最大深度+1的特性来做
    //后序遍历
    int recursion(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = recursion(treeNode.left);
        if (left == -1) return -1;
        int right = recursion(treeNode.right);
        if (right == -1) return -1;
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }
}

public class day18_offer55II {
    public static void main(String[] args) {
        Solution55II solution55 = new Solution55II();
        int[] arr = {3, 9, 20, -1, -1, 15, 7};
        TreeNode root = TreeBuilder.build(arr);
        System.out.println(solution55.isBalanced(root));
    }

}
