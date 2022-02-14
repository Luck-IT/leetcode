package eric;

import java.util.ArrayList;
import java.util.List;


/**
* Solution2
 #description#
* @author:Eric
* @since 1.8
* create 2021年9月18日
*/
public class Solution2 {

    private List<Integer> result = new ArrayList<>();

    public int countNumbersWithUniqueDigits(int n) {
        
        if(n<0){
            return 0;
        }
        result.add(1);
        result.add(10);
    
        for(int i=2;i<=n;i++){
            int tmp = piv(10,i-1)-piv(2,i-2)*9;
            result.add(result.get(i-1)-tmp);
        }
        return result.get(n);

    }

    private int piv(int base,int n){
        int result = 1;
        while(n-->0){
            result*=base;
        }
        return result;
    }

    

    public static void main(String[] args){
        Solution2 s = new Solution2();
        long start = System.currentTimeMillis();
        int result = s.countNumbersWithUniqueDigits(2);
        System.out.println((System.currentTimeMillis()-start)/1000.0);
        System.out.println("===========");
    }
}
