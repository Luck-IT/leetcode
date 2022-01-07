package solution59;

import java.util.Arrays;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月07日
*/
public class Solution {
    public int[][] generateMatrix(int n) {

        if(n == 1){
            return new int[][]{{1}};
        }
        int[][] result = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(result[i],-1);
        }
        //right,down,left,up
        //x,y;水平方向y，竖直方向x
        int[][] direct = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int directIndex = 0;
        int end = n*n;
        int x =0;
        int y= 0;
        for(int i=1;i<=end;i++){
            result[x][y] = i;
            int tmpX = x+direct[directIndex][0];
            int tmpY = y+direct[directIndex][1];
            if(tmpX <0 || tmpX>=n || tmpY <0 ||tmpY>=n || result[tmpX][tmpY] != -1){
                directIndex = (directIndex+1)%4;
                tmpX = x+direct[directIndex][0];
                tmpY = y+direct[directIndex][1];
            }
            x = tmpX;
            y = tmpY;
        }
        return result;
    }
}
