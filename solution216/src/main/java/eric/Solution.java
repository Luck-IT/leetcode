package eric;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Solution
 * #description#
 * 
 * @author:Eric
 * @since 1.8
 *        create 2022年1月18日
 */
public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        backTracing(k, n, result, new LinkedList<>(), 1);
        return result;

    }

    private void backTracing(int k, int sum, List<List<Integer>> result, Deque<Integer> oneResult, int startIndex) {
        if (oneResult.size() == k && sum == 0) {
            result.add(oneResult.stream().collect(Collectors.toList()));
            return;
        }else if( oneResult.size() == k && sum != 0){
            return;
        }

        for (int i = startIndex; i <= sum && i<=9; i++) {
            oneResult.addLast(i);;
            backTracing(k, sum - i, result, oneResult, i + 1);
            oneResult.pollLast();
        }

    }

}
