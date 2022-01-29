package eric;

import java.util.Stack;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月24日
*/
public class Solution {

    public boolean isValid(String s) {
        
        if(s == null || s.length() == 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c:chars){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                Character tmp = stack.pop();
                if(c == ')' && tmp.equals('(')){
                    continue;
                }else if( c == '}' && tmp.equals('{')){
                    continue;
                }else if(c == ']' && tmp.equals('[')){
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
}
