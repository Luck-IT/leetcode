package eric;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0){
            return new int[]{0};
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int[] result = new int[temperatures.length];
        Arrays.fill(result,0);
/*        for(int i = 1;i<temperatures.length;i++){
            if(temperatures[i]>temperatures[stack.peek()]){ //当前元素大于
                while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                    int top = stack.pop();
                    result[top] = i-top;
                }
                stack.push(i);
            } else if (temperatures[i] == temperatures[stack.peek()]) {  //当前元素等于
                stack.push(i);
            }else{ //当前元素小于
                stack.push(i);
            }
        }*/

        //简化代码
        for(int i = 1;i<temperatures.length;i++){
            if(temperatures[i]>temperatures[stack.peek()]){
                while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    int top = stack.pop();
                    result[top] = i-top;
                }
            }
            stack.push(i);
        }
        return result;
    }
}
