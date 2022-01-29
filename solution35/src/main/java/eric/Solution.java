package solution35;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2021年12月28日
*/
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int l = 0;
        int r = nums.length;
        while(l<r){
            int mid = l + (r-l)/2;
            if(target == nums[mid]){
                return mid;
            }else if( target>nums[mid]){
                l = mid+1;
            }else if( target<nums[mid]){
                r = mid;
            }
           
        }
        int n =nums.length-1;
        if(target>nums[n]){
            return nums.length;
        }else if(target<nums[0]){
            return 0;
        }
        return l;
    }
}
