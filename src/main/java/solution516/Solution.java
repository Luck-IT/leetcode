package solution516;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2021年11月18日
*/
public class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.equals("")){
            return 0;
        }
        int[][] result = new int[s.length()][s.length()];

        //这里使用从右向左方向计算，这样每一步都是从最小推导到最大范围
        for(int i=s.length()-1;i>=0;i--){
            result[i][i] = 1;
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    result[i][j] = result[i+1][j-1]+2;
                }else{
                    result[i][j] = Math.max(result[i+1][j], result[i][j-1]);
                }
            }
        }
        return result[0][s.length()-1];
    }

    public void dp(int[][] marked,int i,int j,int n,String s){
        if(i>=n || j>= n ){
            return;
        }
        if(i==j && i<n && marked[i][j] != -1){
            marked[i][j] = 1;
        }
        if(marked[i][j] != -1){
            if(s.charAt(i) == s.charAt(j)){
                dp(marked, i+1, j-1, n, s);
                marked[i][j] = marked[i+1][j-1];
            }else{
                dp(marked, i, j-1, n, s);
                dp(marked, i+1, j, n, s);
                marked[i][j] = Math.max(marked[i+1][j], marked[i][j-1]);
            }
        }
    }
}
