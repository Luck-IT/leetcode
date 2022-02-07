package eric;

/**
 * Solution #description#
 * 
 * @author:Eric
 * @since 1.8 create 2021年11月15日
 */
public class Solution {
    public boolean canJump(int[] nums) {
       if(nums.length == 1 && nums[0]>=0){
         return false;
       }
       int max = 0;
       for(int i=0;i<nums.length;i++){
           if(max >= i){
               max = Math.max(i+nums[i], max);
           }
           if(max >= nums.length-1){
               return true;
           }
       }
       return false;
    }
}
