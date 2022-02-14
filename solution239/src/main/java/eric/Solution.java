package eric;

import java.util.Deque;
import java.util.LinkedList;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月28日
*/
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        if(k<=0){
            return new int[0];
        }
        
        if(k>=nums.length){
            int tmp[] = new int[]{0};
            for(int i = 0;i<nums.length;i++){
                tmp[0] = Math.max(tmp[0], nums[i]);
            }
            return tmp;
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && deque.getLast()< nums[i]){
                deque.removeLast();
            }
            deque.add(nums[i]);
        }
        result[0] = deque.getFirst();
        for(int i=1;i<nums.length-k+1;i++){
            if(nums[i-1] == deque.getFirst()){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && deque.getLast()<nums[i+k-1]){
                deque.removeLast();
            }
            deque.add(nums[i+k-1]);
            result[i] = deque.getFirst();
        }
        return result;

    }
}
