package eric;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class Solution 
{
    public int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
    
        if(nums.length == 1){
            return nums[0] == target ? 1 :(nums[0] == target * (-1) ? 1:0);
        }
        int sum = Arrays.stream(nums).sum();
        // left 表示 选择+
        // right 表示选-
        // 由于目标target = left -right，且 sum  = left + right
        // 则 target = left  - （ sum - left ） = 2 * left -sum --> left = (target + sum)/2
        // 转换为 背包容量为 （target + sum）/2 的背包问题
        // 如果 left % 2 != 0 则无解， 或者 |target| > sum 也无解
        
        if((target+ sum)%2 != 0 || target > sum  ){
            return 0;
        }

        int left = (target + sum )/2;
        int[] dp = new int[left+1];
        dp[0] = 1;
        for(int i = 0;i< nums.length;i++){
            for(int j = left;j>=nums[i];j--){
                dp[j] += dp[j-nums[i]];
            }
        }

        return dp[left];
    }
}
