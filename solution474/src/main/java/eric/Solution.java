package eric;

/**
 * Hello world!
 *
 */
public class Solution 
{
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || strs.length == 0){
            return 0;
        }
        int[][][] dp = new int[strs.length+1][m+1][n+1];
    
        for(int i = 1;i<=strs.length;i++){
            String tmp = strs[i-1];
            int zeroNum = 0;
            int oneNum = 0;

            for(int k = 0;k<tmp.length();k++){
                if(tmp.charAt(k) == '0'){
                    zeroNum++;
                }else{
                    oneNum++;
                }
            }

            for(int mm = 0;mm<= m;mm++){
                for(int nn = 0;nn<=n;nn++){
                    dp[i][mm][nn] = dp[i-1][mm][nn];
                    if(nn>= oneNum && mm>=zeroNum){
                        dp[i][mm][nn] = Math.max(dp[i][mm][nn],dp[i-1][mm-zeroNum][nn-oneNum]+1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}
