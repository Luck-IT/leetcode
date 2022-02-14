package eric;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return null;
        }
        if(target <= 0 ){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        findTarge(candidates, target, result, new ArrayList<Integer>());
        result = result.stream().distinct().collect(Collectors.toList());
        return result;
    }

    private void findTarge(int[] candidates,int target,List<List<Integer>> result,List<Integer> tmp){
        for(int num:candidates){
            if(target-num == 0){
                tmp.add(num);
                List<Integer> tempList = tmp.stream().sorted().map(x-> new Integer(x)).collect(Collectors.toList());
                result.add(tempList);
                tmp.remove(tmp.size()-1);
            }else if( target - num <0){
                continue;
            }else{
                tmp.add(num);
                findTarge(candidates, target-num, result, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> result = s.combinationSum(candidates, target);
        System.out.println(result);
    }
}