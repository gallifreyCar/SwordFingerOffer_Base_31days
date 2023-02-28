

class Solution27 {
    //递归法
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.right;
        root.right = mirrorTree(root.left);
        root.left = mirrorTree(temp);
        return root;
    }


}

public class day07_offer27 {


    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeBuilder.build(arr);
        Solution27 solution27 = new Solution27();
        System.out.println(solution27.mirrorTree(root));
    }


}
