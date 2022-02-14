package eric;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月06日
*/
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int sum =0;
        int i = 0;
        for(int j = 0;j<nums.length;j++){
            sum+=nums[j];
            while(target<=sum){
                int subLength = j-i+1;
                result = result>subLength?subLength:result;
                sum -= nums[i];
                i++;
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}
