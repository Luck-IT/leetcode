package eric;

import java.util.Arrays;

/**
 * Hello world!
 */
public final class Solution {

    public int lastStoneWeightII(int[] stones) {
        if( stones == null || stones.length == 0 ){
            return 0;
        }
        if(stones.length == 1){
            return stones[0];
        }
        int sum = Arrays.stream(stones).sum();
        int maxLength = sum/2;
        int [][] dp = new int[stones.length][maxLength+1];
        for(int i =0;i<=maxLength;i++){
            if(i<stones[0]){
                dp[0][i] = 0;
            }else{
                dp[0][i] =  stones[0];
            }
        }
        for(int i = 1;i<stones.length;i++){
            for(int j = 1;j<=maxLength;j++){
                if(j<stones[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i]]+stones[i]);
                }
            }
        }
        return sum - dp[stones.length-1][maxLength] * 2;
    }
}
