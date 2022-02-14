package eric;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月17日
*/
public class Solution {
    public boolean isHappy(int n) {
        if(n <= 0){
            return false;
        }

        Set<Integer> sums = new HashSet();
        while(true){
            int sum = getNum(n).stream().map(v->v*v).reduce(0,(a,b)->{return a+b;});
            if(sum == 1){
                return true;
            }
            if(sums.contains(sum)){
                return false;
            }
            sums.add(sum);
            n = sum;
        }
    }


    private List<Integer> getNum(int n){
        List<Integer> result = new ArrayList();
        while(n>0){
            int temp = n%10;
            result.add(temp);
            n = n/10;
        }
        return result;
    }
}
