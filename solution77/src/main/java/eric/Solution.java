package eric;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class Solution{

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> one = new LinkedList<>();
        trace(n, k, result, one,1);
        return result;
    }

    private void trace(int n,int k,List<List<Integer>> result,Deque<Integer> oneResult,int startIndex){
        if(oneResult.size() == k){
            result.add(oneResult.stream().collect(Collectors.toList()));
            return;
        }
        for(int i = startIndex;i<=n - (k-oneResult.size())+1;i++){
            oneResult.addLast(i);
            trace(n, k, result,oneResult, i+1);
            oneResult.pollLast();
        }
    }
}
