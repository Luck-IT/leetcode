package eric;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Solution 
{
    public int fib(int n) {
        if(n <2){
            return n;
        }
        List<Integer> dp = new ArrayList<>();
        dp.add(0,0);
        dp.add(1,1);
        for(int i=2;i<=n;i++){
            dp.add(i, dp.get(i-2)+dp.get(i-1));
        }
        return dp.get(n);
    }

    public int fib2(int n) {
        if(n <2){
            return n;
        }
        int[] dp = new int[]{0,1};
        for(int i = 2;i<=n;i++){
            int sum = dp[0]+dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
        
    }
}
