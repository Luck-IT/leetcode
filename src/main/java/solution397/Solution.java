package solution397;

import java.util.HashMap;
import java.util.Map;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2021年12月01日
* 397
*/
public class Solution {

    private Map<Integer,Integer> record = new HashMap();

    public int integerReplacement(int n) {
        if(n == 1){
            return 0;
        }
        if(!record.containsKey(n)){
            if(n%2 == 0){
                record.put(n,integerReplacement(n/2)+1);
            }else{
                record.put(n,2+Math.min(integerReplacement(n/2),integerReplacement(n/2+1)));
            }
        }
        return record.get(n);
    }
}
