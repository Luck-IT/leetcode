package solution3;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if(s == null ||s.equals("")){
            return 0;
        }
        Set<Character> duplicate = new HashSet<>();
        int max = 0;
        int r = 1;
        duplicate.add(s.charAt(0));
        for(int i = 0;i<s.length();i++){
           for(;r<s.length();){
               if(!duplicate.contains(s.charAt(r))){
                   duplicate.add(s.charAt(r));
                   r++;
               }else{
                   break;
               }
           }
           max = max> duplicate.size()?max:duplicate.size();
           duplicate.remove(s.charAt(i));
        }
        return max;
    }
}