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
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        Arrays.fill(count, 0);
        for(int i=0;i<magazine.length();i++){
            char c = magazine.charAt(i);
            count[c-'a']++;
        }

        for(int i = 0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            count[c-'a']--;
            if(count[c-'a']<0){
                return false;
            }
        }
        return true;
    }
}
