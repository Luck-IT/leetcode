package solution118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2021年11月16日
*/
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        if(numRows <=0){
            return Collections.emptyList();
        }
        if(numRows == 1){
            return Stream.of(Stream.of(1).collect(Collectors.toList())).collect(Collectors.toList());
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(Stream.of(1).collect(Collectors.toList()));
        for(int i =2;i<=numRows;i++){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for(int j = 1;j<i;j++){
                if(j==i-1){
                    tmp.add(1);
                }else{
                    tmp.add(result.get(i-2).get(j-1)+result.get(i-2).get(j));
                }
            }
            result.add(tmp);
        }
        return result;
    }

    public static void main(String[] agrs) {
        Solution s = new Solution();
        System.out.println(s.generate(5));
    }

}
