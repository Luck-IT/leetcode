package eric;

import java.util.ArrayList;
import java.util.List;


/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2021年11月17日
*/
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null ){
            return 0;
        }
        if(matrix.length == 1){
            int max = 0;
            for(int i=0;i<matrix[0].length;i++){
                max = Math.max(matrix[0][i]=='1'?1:0, max);
            }
            return max;
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<matrix.length;i++){
            result.add(new ArrayList<Integer>(matrix[0].length));
            for(int k =0;k<matrix[0].length;k++){
                result.get(i).add(0);
            }
            for(int j=0;j<matrix[i].length;j++){
                if(i == 0 || j== 0){
                    result.get(i).set(j,matrix[i][j] == '1'?1:0);
                }else{
                    if(matrix[i][j] == '0'){
                        result.get(i).set(j,0);
                    }else{
                        int tmp = Math.min(result.get(i-1).get(j),result.get(i).get(j-1));
                        tmp = Math.min(tmp,result.get(i-1).get(j-1));
                        result.get(i).set(j,tmp+1);
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i =0;i<result.size();i++){
            for(int j=0;j<result.get(0).size();j++){
                max = Math.max(max,result.get(i).get(j));
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
        System.out.println("end");
    }
}
