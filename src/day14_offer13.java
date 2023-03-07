import java.util.LinkedList;

class Solution13 {
    //bfs 搜索所有
    public int movingCount(int m, int n, int k) {
        boolean[][] signs = new boolean[m][n];

        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int count = 0;
        while (queue.size() > 0) {

            int[] temp = queue.poll();
            int i = temp[0];
            int j = temp[1];
            if (i == m || j == n || signs[i][j]) continue;
            //标记走过的点 防止重复入栈
            signs[i][j] = true;
            count++;

            //先下后右
            if (isTrue(i + 1, j, k)) queue.offer(new int[]{i + 1, j});
            if (isTrue(i, j + 1, k)) queue.offer(new int[]{i, j + 1});

        }
        return count;
    }


    //dfs
    public int movingCount2(int m, int n, int k) {
        boolean[][] signs = new boolean[m][n];
        return recursion(0, 0, m, n, k, signs, 0);
    }

    public int recursion(int i, int j, int m, int n, int k, boolean[][] signs, int num) {
        if (i >= m || j >= n || !isTrue(i, j, k) || signs[i][j]) return 0;
        signs[i][j] = true;
        return recursion(i + 1, j, m, n, k, signs, num) + recursion(i, j + 1, m, n, k, signs, num) + 1;
    }


    boolean isTrue(int i, int j, int k) {
        return ((i % 10) + (i / 10) + (j % 10) + (j / 10)) <= k;
    }
}

public class day14_offer13 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        System.out.println(solution13.movingCount(3, 2, 17));
        System.out.println(solution13.movingCount2(3, 2, 17));
    }

}
