package eric;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution
 * #description#
 * @author:Eric
 * @since 1.8
 * create 2022年1月18日
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length <2){
            return new int[0];
        }

        Map<Integer,Integer> pos = new HashMap();
        for(int i=0;i<nums.length;i++){
            pos.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){

            if(pos.containsKey(target-nums[i]) && pos.get(target-nums[i]) != i){
                return new int[]{i,pos.get(target-nums[i])};
            }
        }
        return new int[0];
    }

}
