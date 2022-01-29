package solution300;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //以i结尾的最大上升序列长度
        int[] dp = new int[nums.length];
        //初始化dp数组，每个元素为1，因为所有元素都可以是以自身结尾且长度为1
        for(int i= 0;i<nums.length;i++){
            dp[i] = 1;
        }

        for(int i = 1;i<nums.length;i++){
            //从0到i查找所有小于当前元素nums[i]的最大值长度，
            //并在此基础上加上1，则为当前元素的最大长度
            int max = Integer.MIN_VALUE;
            for(int j= 0;j<i;j++){
                if(nums[i]>nums[j]){
                   max = dp[j]>max ? dp[j]:max;
                }
            }

            if(max+1>dp[i]){
                dp[i] = max+1;
            }
        }

        //从dp数组中查找最大上升子序列
        int max = dp[0];
        for(int tmp :dp){
            if(tmp > max){
                max = tmp;
            }
        }
        return max;
    }
    

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int result = s.lengthOfLIS(nums);
        System.out.println(result);
    }
}