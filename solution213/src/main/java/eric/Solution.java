package eric;

import java.util.Arrays;

/**
 * Hello world!
 */
public final class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        //考虑首元素
        dp[0] = nums[0];
        if(nums.length >1){
            dp[1] = Math.max(dp[0], nums[1]);
        }
        for(int i= 2;i<nums.length-1;i++){
            dp[i] = Math.max(dp[i-1],nums[i] + dp[i-2]);
        }
        
        int includeFirst = dp[nums.length-2];

        //不考虑首元素，考虑尾部元素
        Arrays.fill(dp,0);
        dp[0] = 0;
        if(nums.length >1){

            dp[1] = nums[1];
        }
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }

        return Math.max(dp[nums.length-1], includeFirst);
    }
}
