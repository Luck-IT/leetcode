package solution304;

import java.rmi.MarshalException;

/**
 * leetCode question 304
 * (https://leetcode-cn.com/problems/range-sum-query-2d-immutable/)
 */
public class NumMatrix {

    private int[][] dp = null;
    private int rLength = 0;
    private int cLength = 0;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            this.dp = new int[1][1];
            this.dp[0][0] = 0;
        } else {
            this.dp = new int[matrix.length + 1][matrix[0].length + 1];
   
            //计算并初始化dp数组
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix[0].length; c++) {
                    this.dp[r+1][c+1] = this.dp[r+1][c] + this.dp[r][c+1] + matrix[r][c]-this.dp[r][c];
                }
            }
            this.rLength = matrix.length;
            this.cLength = matrix[0].length;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 < 0||col1< 0 || row2<0 || col2 <0){
            return 0;
        }
        if(row1>row2 || col1 > col2 ){
            return 0;
        }
        if( row1>rLength || row2 >rLength || col1 > cLength || col2 > cLength){
            return 0;
        }
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };
        NumMatrix matrixObj = new NumMatrix(matrix);
        System.out.println(matrixObj.sumRegion(2, 1,4,3));
        System.out.println(matrixObj.sumRegion(1,1,2,2));
        System.out.println(matrixObj.sumRegion(1,2,2,4));

    }
}