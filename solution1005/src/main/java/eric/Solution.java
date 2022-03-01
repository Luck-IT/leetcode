package eric;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Hello world!
 *
 */
public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                result += nums[i];
            }
        } else {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int i=0;i<nums.length;i++){
                queue.add(nums[i]);
            }
            while(k>0){
                Integer tmp = queue.poll();
                tmp = tmp*(-1);
                queue.add(tmp);
                k--;
            }
            while(!queue.isEmpty()){
                result+=queue.poll();
            }
        }
        return result;
    }
}
