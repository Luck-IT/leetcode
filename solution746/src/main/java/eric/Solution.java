package eric;

/**
 * Hello world!
 *
 */
public class Solution 
{
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[]{cost[0],cost[1]};
        for(int i =2;i<cost.length;i++){
            int tmp = Math.min(dp[1],dp[0])+cost[i];
            dp[0] = dp[1];
            dp[1] = tmp;
        }
        return Math.min(dp[0],dp[1]);
    }
}
