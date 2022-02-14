package eric;

public class Solution {
    
    //解法一
    public int combinationSum4( int[] nums, int target) {
        if(nums == null || nums.length == 0 || target <= 0){
            return 0;
        }
        int[] result = new int[target+1];
        result[0] = 0;
        result[1] = 0;
        for(int i= 1;i<= target;i++){
            int tmp = 0;
            for(int j =0;j<nums.length;j++){
                if(i - nums[j] > 0){
                    tmp += result[i-nums[j]];
                }else if(i - nums[j] == 0){
                    tmp += 1;
                }
            }
            result[i] = tmp;
        }
        return result[target];
    }
    //解法二 暴力破解
    public int combinationSum4_2(int[] nums, int target){

        if(nums == null || nums.length == 0 || target <= 0){
            return 0;
        }
        int[] count = new int[]{0};
        help2(nums, target, count);
        return count[0];
    }

    private void help2(int[] nums,int target,int[] count){
        for(int i = 0;i<nums.length;i++){
            if(target - nums[i] > 0){
                help2(nums, target-nums[i], count);
            }else if( target  - nums[i] == 0){
                count[0] += 1;
            }
        }
    }
    //--------------------------------------------

    //解法三--------------------------------------
    public int combinationSum4_3(int[] nums, int target){

        if(nums == null || nums.length == 0 || target <= 0){
            return 0;
        }
       
        int[] record = new int[target+1];
        for(int i=0;i<=target;i++){
            record[i] = -1;
        }
        record[0] = 0;
        int count = help_3(nums, target, record);
        return count;
    }

    private int help_3(int[] nums,int target,int[] record){
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(target - nums[i] > 0){
                if(record[target-nums[i]]!=-1){
                    count += record[target-nums[i]];
                    continue;
                }
                count += help_3(nums, target-nums[i], record);
            }else if( target - nums[i] == 0){
                count += 1;
            }
        }
        record[target] = count;
        return count;
    }
    //-------------------------------------------
}