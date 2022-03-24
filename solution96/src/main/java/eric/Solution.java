package eric;

/**
 * Solution
 * #description#
 * @author:Eric
 * @since 1.8
 * create 2022年1月18日
 */
public class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i= 2;i<=n;i++){
            for(int j= 1;j<= i;j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

}
