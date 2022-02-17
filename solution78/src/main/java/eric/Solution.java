package eric;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
       backTracing(result, 0,new LinkedList<Integer>(), nums);
       return result;
    }

    private void backTracing(List<List<Integer>> result,int starIndex,Deque<Integer> oneResult,int[] nums){
       List<Integer> tmp = new ArrayList<>(oneResult);
       result.add(tmp);
       for(int i=starIndex;i<nums.length;i++){

            oneResult.addLast(nums[i]);
            backTracing(result, i+1, oneResult, nums);
            oneResult.removeLast();
        }
    }



}
