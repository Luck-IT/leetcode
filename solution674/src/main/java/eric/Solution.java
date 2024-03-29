package eric;

import java.util.Arrays;

public class Solution {


    public int findLengthOfLCIS(int[] nums) {
        if(nums== null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i =1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i] = dp[i-1]+1;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

}
