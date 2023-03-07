
class Solution54 {

    // 递归法      右    根   左，搜索一次
    int res;
    int k;

    public int kthLargest(TreeNode root, int k) {

        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.right);
        --k;
        if (k == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);

    }

}

public class day15_offer54 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, -1, 2};
        TreeNode root = TreeBuilder.build(arr);
        System.out.println(root);
        Solution54 solution54 = new Solution54();
        System.out.println(solution54.kthLargest(root, 1));
    }
}
