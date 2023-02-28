class Solution26 {
    //判断 B树是不是A的子树
    //递归法
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return A != null && B != null && (recursion(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean recursion(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        //A为空B不为空，或者他们的值不相等
        if (A == null || A.val != B.val) {
            return false;
        }
        return recursion(A.left, B.left) && recursion(A.right, B.right);
    }
}

public class day07_offer26 {
    public static void main(String[] args) {
        int a[] = {4, 2, 3, 4, 5, 6, 7, 8, 9};
        int b[] = {4, 8, 9};
        TreeNode A = TreeBuilder.build(a);
        TreeNode B = TreeBuilder.build(b);
        Solution26 solution26 = new Solution26();
        System.out.println(solution26.isSubStructure(A, B));
    }

}
