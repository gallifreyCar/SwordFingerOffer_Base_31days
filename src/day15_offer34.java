import javax.swing.event.ListDataListener;
import java.util.LinkedList;
import java.util.List;

class Solution34 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return new LinkedList<>();


        LinkedList list = new LinkedList();
        list.add(root.val);
        dfs(root, target, list, root.val);
        return res;
    }

    void dfs(TreeNode root, int target, LinkedList<Integer> list, int sum) {

        if (sum == target && root.right == null && root.left == null) {
            res.add((List<Integer>) list.clone());

        }
        if (root.left != null) {
            list.add(root.left.val);
            dfs(root.left, target, list, sum + root.left.val);
            list.removeLast();
        }

        if (root.right != null) {
            list.add(root.right.val);
            dfs(root.right, target, list, sum + root.right.val);
            list.removeLast();
        }

    }
}

public class day15_offer34 {
    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] arr = {5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1};
        int target = 22;
        arr = new int[]{-2, -1, -3};

        target = -5;
        TreeNode root = TreeBuilder.build(arr);
        System.out.println(root);
        System.out.println(solution34.pathSum(root, target));


    }
}
