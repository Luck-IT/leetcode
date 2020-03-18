package solution375;

public class Solution {

    public int getMoneyAmount(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][i] = 0;
        }
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start < n - len + 1; start++) {
                int min = Integer.MAX_VALUE;
                for(int piv = start;piv<=start+len-1;piv++){
                    int tmp = Math.min(dp[start][piv-1],dp[piv+1][start+len-1]);
                    min = Math.min(min,tmp+piv);
                }
                dp[start][n-len+1]=min;
            }
        }
        return dp[1][n];
    }
}