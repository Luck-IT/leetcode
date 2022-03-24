package eric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Hello world!
 *
 */
public class Solution 
{
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return false;
        }
        int summer = 0;
        for(int i = 0;i<nums.length;i++){
            summer += nums[i];
        }
        if(summer % 2 != 0){
            return false;
        }
        int target = summer/2;
        int[] dp = new int[target+1];
        Arrays.fill(dp, 0);
        for(int i = 0;i<nums.length;i++){
            for(int j = target;j>=nums[i];j--){
                dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
            }
        }

        return dp[target] == target;

    }

    private boolean recu(Map<Integer,Integer> partOne,int[] nums,int summer){
        
        int partSum = partOne.isEmpty()?0:partOne.entrySet().stream().map(v->v.getValue()).reduce(0,(a,b)->a+b).intValue();
        if(partSum>summer/2){
            return false;
        }
        for(int i = 0;i<nums.length;i++){
            if(partOne.containsKey(i)){
                continue;
            }
            partOne.put(i,nums[i]);
            partSum += nums[i];
            if(partSum == summer/2){
                return true;
            }
            boolean result = false;
            if(partSum<(summer/2)){
                result = recu(partOne,nums,summer);
                if(result){
                    return true;
                }
            }
            partOne.remove(i);
            partSum -= nums[i];
        }
        return false;
    }
}
