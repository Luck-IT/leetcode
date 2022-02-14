package eric;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月24日
*/
public class Solution {
    public String removeDuplicates(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        int top = -1;
        char[] chars = s.toCharArray();
        for(int i=0;i<s.length();i++){
         if(top == -1){
             top++;
              chars[top] = chars[i];
         }else if(chars[top]!= chars[i]){
             top++;
             chars[top] = chars[i];
         }else if(chars[top] == chars[i]){
             top--;
         }
        }
        if(top == -1){
            return new String();
        }
        return new String(chars,0,top+1);
    }
}
