package solution26;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2021年12月31日
*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int slow = 1;
        int fast = 1;
        for(;fast<nums.length;fast++){
            if(nums[fast-1]!=nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
