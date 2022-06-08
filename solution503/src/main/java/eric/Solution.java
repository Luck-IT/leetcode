package eric;

import java.util.Arrays;
import java.util.Stack;

/**
 * Hello world!
 */
public class Solution {

    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        Stack<Integer> stack =new Stack<>();
        stack.push(0);
        for(int i=1;i<nums.length*2;i++){
            while (!stack.isEmpty() && nums[stack.peek()]<nums[i%nums.length]){
                int top = stack.pop();
                result[top] = nums[i%nums.length];
            }
            stack.push(i%nums.length);
        }
        return result;
    }

}
