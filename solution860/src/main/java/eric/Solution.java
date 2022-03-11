package eric;

import java.util.HashMap;
import java.util.Map;



public class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        if(bills == null || bills.length == 0){
            return false;
        }
        Map<Integer,Integer> remine = new HashMap<>();
        remine.put(5,0);
        remine.put(10,0);
        remine.put(20,0);
        for(int i = 0;i<bills.length;i++){
            if(bills[i] == 5){
                int tmp = remine.get(5)+1;
                remine.put(5,tmp);
            }else if(bills[i] == 10){
                int tmp = remine.get(5);
                if(tmp<=0){
                    return false;
                }
                remine.put(5,tmp-1);
                tmp = remine.get(10);
                remine.put(10,tmp+1);
            }else if(bills[i] == 20){
                int tmp_10 = remine.get(10);
                int tmp_5 = remine.get(5);
                if(tmp_10>=1 && tmp_5<1){
                    return false;
                }
                if(tmp_10<=0 && tmp_5<3){
                    return false;
                }
                if(tmp_10 >=1){
                    tmp_10 = tmp_10-1;
                    tmp_5 = tmp_5-1;
                    remine.put(10,tmp_10);
                    remine.put(5,tmp_5);
                }else{
                    tmp_5 = tmp_5-3;
                    remine.put(5,tmp_5);
                }
                int tmp = remine.get(20);
                remine.put(20,tmp+1);
            }
        }
        return true;

    }
}
