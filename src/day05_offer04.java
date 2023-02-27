class Solution04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        } else if (
                matrix[0].length == 0
        ) {
            return false;
        }

        int n = matrix[0].length - 1;//n+1列
        int m = matrix.length - 1;//m+1行
        int i = 0;
        int j = n;


        while (true) {
            if (target > matrix[i][j]) {
                if (i + 1 > m) {
                    return false;
                }
                i++;
            }
            if (target < matrix[i][j]) {
                if (j - 1 < 0) {
                    return false;
                }
                j--;
            }
            if (target == matrix[i][j]) {
                return true;
            }

        }

    }
}

public class day05_offer04 {
    public static void main(String[] args) {
        Solution04 solution04 = new Solution04();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int[][] matrix2 = {{}};
        System.out.println(solution04.findNumberIn2DArray(matrix, 5));
        System.out.println(solution04.findNumberIn2DArray(matrix2, 5));

    }

}
