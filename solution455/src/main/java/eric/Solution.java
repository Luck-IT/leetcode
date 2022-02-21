package eric;

import java.util.Arrays;

/**
 * Solution
 * #description#
 * @author:Eric
 * @since 1.8
 * create 2022年1月18日
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g == null || g.length ==0){
            return 0;
        }
        if(s == null || s.length == 0){
            return 0;
        }
        Arrays.sort(s);
        Arrays.sort(g);
        int count = 0;
        for(int is = s.length-1,ig = g.length-1;is>=0 && ig>=0;){
            if(s[is]>=g[ig]){
                count++;
                ig--;
                is--;
            }else{
                ig--;
            }
        }
        return count;
    }
}
