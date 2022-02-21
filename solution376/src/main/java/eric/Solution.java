package eric;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        return findMaxLength2(nums);
    }

    private int findMaxLength(int[] nums){
        int[][] dp= new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for(int i= 1;i<nums.length;i++){
            dp[i][0] = 1;
            for(int j = 0;j<i;j++){
                if( (nums[i]-nums[j] != 0 )&&((nums[i]-nums[j]) * dp[j][1] <= 0) ){
                    boolean changeFlag = dp[j][0]+1 > dp[i][0] ? true:false;
                    if(changeFlag){
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = nums[i]-nums[j]>0 ? 1:-1; ;
                    }
                }
            }
        }
        int max = dp[0][0];
        for(int i=0;i<nums.length;i++){
            max = dp[i][0] > max ? dp[i][0]:max;
        }
        return max;
    }

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    private int findMaxLength2(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length<2){
            return nums.length;
        }

        int result = 1;
        int pre = 0;
        int cur = 0;
        for(int i=0;i<nums.length-1;i++){
            cur = nums[i+1]-nums[i];
            if((pre <= 0 && cur >0)||(pre >= 0 && cur <0)){
                result++;
                pre = cur;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] test = new int[]{1,7,4,9,2,5};
        Solution s = new Solution();
        System.out.println(s.wiggleMaxLength(test));
    }
}