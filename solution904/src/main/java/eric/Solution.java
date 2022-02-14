package eric;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月06日
*/
public class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits == null || fruits.length ==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i =0;i<fruits.length;i++){
            int tmp = 0;
            Set<Integer> set = new HashSet<>();
            set.add(fruits[i]);
            for(int j=i;j<fruits.length;j++){
                if(!set.contains(fruits[j]) && set.size()>=2 ){
                    break;
                }
                set.add(fruits[j]);
                tmp++;
            }
            max = max >tmp ?max:tmp;
        }
        return max;
    }

    /**
     * 滑动窗口解法
     * @param fruits
     * @return
     */
    public int totalFruit2(int[] fruits){
        if(fruits == null || fruits.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int j = 0;
        int i= 0;
        Map<Integer,Integer> count = new HashMap<>();
        for(;j<fruits.length;j++){
            count.put(fruits[j],count.getOrDefault(fruits[j],0)+1);
            while(count.size()>2){
                count.put(fruits[i],count.get(fruits[i])-1);
                if(count.get(fruits[i])==0){
                    count.remove(fruits[i]);
                }    
                i++;
            }
        
            max = max>j-i+1?max:j-i+1;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long start = System.currentTimeMillis();
        int result = s.totalFruit2(new int[]{0,1,2,2});
        System.out.println((System.currentTimeMillis()-start)/1000.0);
    }
}
