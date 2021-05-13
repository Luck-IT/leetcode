package solution40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.namespace.QName;

public class Solution {

    //记忆已经求解出的结果
    private Map<Integer,List<List<Integer>>> mem = null;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0 || target <= 0){
            return new ArrayList<List<Integer>>();
        }
        //0表示未使用，1使用
        int[] used = new int[candidates.length];
        mem = new HashMap<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        find(candidates, used, target, result,new ArrayList<Integer>());
        result = result.stream().distinct().collect(Collectors.toList());
        return result;
    }

    public void find(int[] candidates,int[] used,int target,List<List<Integer>> result,List<Integer> tmp){
        
        for(int i=0;i< candidates.length;i++){
            if(used[i] == 1){
                continue;
            }
            int restNum = target - candidates[i];
            if(restNum > 0){
              used[i] = 1;
              tmp.add(candidates[i]);
              find(candidates, used, restNum, result, tmp);
              tmp.remove(tmp.size()-1);
              used[i] = 0;
            }else if(restNum == 0){
                tmp.add(candidates[i]);
                List<Integer> tmpResult = tmp.stream().sorted().collect(Collectors.toList());
                result.add(tmpResult);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        List<List<Integer>> result = s.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
        System.out.println(result);
    }
}