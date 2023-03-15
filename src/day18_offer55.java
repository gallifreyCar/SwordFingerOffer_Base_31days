/**
 * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof
 */

class Solution55 {
    int maxLen = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return maxLen;
    }

    void dfs(TreeNode treeNode, int temp) {
        if (treeNode == null) {
            maxLen = Math.max(maxLen, temp);
            return;
        }
        dfs(treeNode.left, temp + 1);
        dfs(treeNode.right, temp + 1);
    }
}

public class day18_offer55 {


    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        int[] arr = {3, 9, 20, -1, -1, 15, 7};
        TreeNode root = TreeBuilder.build(arr);
        System.out.println(solution55.maxDepth(root));
    }
}
