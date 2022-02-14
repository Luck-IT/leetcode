package eric;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月20日
*/
public class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length() == 0){
            return s;
        }

        //删除多余空格
        int slow = 0;
        int fast = 0;
        char[] chars = s.toCharArray();
        while (chars[fast] == ' ' && fast<chars.length) {
            fast++;
        }

        while(fast<chars.length){
            if(fast-1 > 0 && chars[fast-1] == chars[fast] && chars[fast]==' '){
                fast++;
            }else{
                chars[slow] = chars[fast];
                slow++;
                fast++;
            }
        }

        if(slow -1 > 0 && chars[slow-1] == ' '){
            s = new String(chars,0,slow-1);
        }else{
            s = new String(chars,0,slow);
        }

        chars = s.toCharArray();
        int left = 0,right = s.length()-1;
        while(left<right){
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }

        for(int i = 0,start = 0;i<chars.length;i++){
            if(chars[i] != ' ' && i <chars.length-1){
                continue;
            }
            int tmpleft = start;
            int tmpRight= i==chars.length-1?i:i-1;
            while(tmpleft<tmpRight){
                char tmp = chars[tmpleft];
                chars[tmpleft] = chars[tmpRight];
                chars[tmpRight]=tmp;
                tmpleft++;
                tmpRight--;
            }
            start = i+1;
        }
        s = new String(chars);
        return s;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.reverseWords("the sky is blue");
    
    }
}
