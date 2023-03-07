class Solution12 {


    //遍历所有的点 dfs搜索一次
    char[][] board;
    int[][] sign;
    char[] chars;
    int charPoint = 0;

    boolean flag = false;

    boolean dfs(int i, int j, int charPoint) {

        sign[i][j] = 1;
        if (board[i][j] != chars[charPoint]) return false;
        if (charPoint == chars.length - 1) {
            flag = true;
            return true;
        }


        //右下左上 顺时针深搜
        if (j < board[0].length - 1) {
            if (sign[i][j + 1] == 0) {

                dfs(i, j + 1, charPoint + 1);
                sign[i][j + 1] = 0;
            }
        }
        if (i < board.length - 1) {
            if (sign[i + 1][j] == 0) {
                dfs(i + 1, j, charPoint + 1);
                sign[i + 1][j] = 0;
            }
        }

        if (j > 0) {
            if (sign[i][j - 1] == 0) {
                dfs(i, j - 1, charPoint + 1);
                sign[i][j - 1] = 0;
            }
        }
        if (i > 0) {
            if (sign[i - 1][j] == 0) {
                dfs(i - 1, j, charPoint + 1);
                sign[i - 1][j] = 0;
            }
        }


        return flag;
    }


    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        this.board = board;
        chars = word.toCharArray();
        sign = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0)) return true;
                sign = new int[board.length][board[0].length];
            }
        }

        return false;
    }
}

public class day14_offer12 {


    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCEFSADEESE";
        Solution12 solution12 = new Solution12();
        System.out.println(solution12.exist(board, word));
    }

}
