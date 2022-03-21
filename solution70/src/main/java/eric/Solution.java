package eric;

/**
 * Hello world!
 *
 */
public class Solution 
{
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] dp = new int[]{0,1,2};
        for(int i=3;i<=n;i++){
            int tmp = dp[1]+dp[2];
            dp[1] = dp[2];
            dp[2] = tmp;
        }
        return dp[2];
    }
}
