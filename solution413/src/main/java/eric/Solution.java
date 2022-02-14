package eric;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2021年12月02日
*/
public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums == null || nums.length <=2){
            return 0;
        }
        int result = 0;
        int delt = nums[1]-nums[0];
        int tmpResult = 0;
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1] == delt){
                tmpResult++;
            }else{
                tmpResult = 0;
                delt = nums[i]-nums[i-1];
            }
            result+=tmpResult;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.numberOfArithmeticSlices(new int[]{1,2,3,8,9,10});
        System.out.println(result);
    }

}
