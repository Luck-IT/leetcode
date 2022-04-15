package eric;

/**
 * Hello world!
 *
 */
public class Solution 
{
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0 || prices.length ==1){
            return 0;
        }
        //dp[i][0] 第i天不持有股票的最大利润
        //dp[i][1] 第i天持有股票的最大利润

        //dp[i][0]= max(dp[i-1][0],dp[i-1][1]+prices[i])
        //dp[i][1] = max(dp[i-1][1],-1*prices[i]);
        int[][] dp = new int[prices.length][2];

        //initial
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        
        for(int i= 1;i<prices.length;i++){
            dp[i][1] = Math.max(dp[i-1][1], -1*prices[i]);
            dp[i][0] = Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
        }

        return dp[prices.length-1][0];//收益最大肯定是不持有股票

    }
}
