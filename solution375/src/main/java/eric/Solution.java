package eric;

public class Solution {

    public int getMoneyAmount(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int[][] dp = new int[n+1][n+1];
        return cost(1,n,dp);
    }
    int cost(int low,int high,int[][] dp){
        if(low>=high){
            return 0;
        }
        if(dp[low][high] != 0){
            return dp[low][high];
        }
        int min = Integer.MAX_VALUE;
        for(int i = (low+high)/2;i<=high;i++){
            int tmp = Math.max(cost(low,i-1,dp), cost(i+1,high,dp));
            min = Math.min(tmp+i, min);
        }
        dp[low][high] = min;
        return min;
    }
}