package eric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Solution 
{
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            return result;
        }

        char[] strChars = s.toCharArray();
        int[] maxLength = new int[26];
        Arrays.fill(maxLength, -1);
        for(int i =0;i<strChars.length;i++){
            maxLength[strChars[i]-'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for(int i = 0;i<strChars.length;i++){
            idx = Math.max(idx, maxLength[strChars[i]-'a']);
            if(i == idx){
                result.add(i-last);
                last = i;
            }
        }
        return result;
    }
}
