package eric;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月19日
*/
public class Solution {
    public String replaceSpace(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        int oldSize = s.length();
        StringBuilder str = new StringBuilder();
        for(int i=0;i<oldSize;i++){
            if(s.charAt(i)==' '){
                str.append("  ");
            }
        }
        if(str.length() == 0){
            return s;
        }
        s += str;
        int left = oldSize-1;
        int right = s.length()-1;
        char[] chars = s.toCharArray();
        while(left>=0){
            if(chars[left] == ' '){
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }else{
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }
}
