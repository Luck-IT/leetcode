package eric;

/**
 * Hello world!
 *
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums == null ? 0 : nums[0];
        }
        int result = Integer.MIN_VALUE;
        int count = 0;
    
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result) {
                result = count;
            }
            if (count <= 0) {
                count = 0;
            }
        }
        return result;
    }

    //递归算法
    public int maxSubArray2(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        //1 dp[i] 表示包括i之前的最大子序和
        int[] dp = new int[nums.length];
        //2 递推公式
        // dp[i] = max(dp[i-1]+nums[i],nums[i])
        //3 初始化 dp[0] = nums[0]
        dp[0] = nums[0];
        //4 确定递推顺序
        for (int i=1;i<nums.length;i++){
            dp[i] =Math.max(dp[i-1]+nums[i],nums[i]);
        }
        return dp[nums.length-1];
    }
}
