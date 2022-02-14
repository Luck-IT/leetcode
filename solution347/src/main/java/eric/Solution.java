package eric;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月28日
*/
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k<=0){
            return new int[0];
        }
        Map<Integer,Integer> frequent = new HashMap<>();
        for(int e:nums){
            frequent.compute(e,(key,v)->{
                if(v == null){
                    return 1;
                }else{
                    return v+1;
                }
            });
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>((v1,v2)->v1.getValue()-v2.getValue());
        for(Map.Entry<Integer,Integer> entry:frequent.entrySet()){
          if(priorityQueue.size()<k){
              priorityQueue.offer(entry);
          }else{
              if(entry.getValue()>priorityQueue.peek().getValue()){
                  priorityQueue.poll();
                  priorityQueue.add(entry);
              }
          }
        }
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = priorityQueue.poll().getKey();
        }

        return result;

    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] result = s.topKFrequent(new int[]{1,1,1,2,2,3},2);
        System.out.println("===========");
    }
}
