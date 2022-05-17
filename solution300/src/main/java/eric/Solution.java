package eric;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //以i结尾的最大上升序列长度
        int[] dp = new int[nums.length];
        //递推公式
        //dp[i] = max(dp[i],nums[j]<nums[i]?dp[j]+1:1)(0<=j<i)
        //初始化dp数组，每个元素为1，因为所有元素都可以是以自身结尾且长度为1
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        int max = 1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                dp[i] = Math.max(dp[i],nums[j]<nums[i]?dp[j]+1:1);
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}