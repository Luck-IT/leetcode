package solution242;

import java.util.Arrays;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月17日
*/
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        if("".equals(s) && "".equals(t)){
            return true;
        }
        if(s.length()!= t.length()){
            return false;
        }
        int[] record = new int[26];
        Arrays.fill(record,0);

        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            int pos = c-'a';
            if(pos<26){
                record[pos]++;
            }
        }
        for(int i = 0;i<t.length();i++){
            char c = t.charAt(i);
            int pos = c - 'a';
            if(pos<26){
                record[pos]--;
            }
        }

        for(int i= 0;i<26;i++){
            if(record[i] != 0){
                return false;
            }
        }
        return true;
    }
}
