package eric;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月19日
*/
public class Solution {
    public void reverseString(char[] s) {
        if(s == null || s.length ==0){
            return;
        }
        int i = 0;
        int j = s.length-1;
        while(i<j){
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
