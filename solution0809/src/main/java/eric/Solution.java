package eric;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public List<String> generateParenthesis(int n) {
        if(n<= 0){
            return new ArrayList<String>();
        }

        List<String> reResult = new ArrayList<>();
        char[] tmpResult = new char[n*2];
        tmpResult[0] = '(';
        find(reResult, tmpResult,0, 1,n);
        return reResult;
    }

    private void find(List<String> reResult,char[] tmpResult,int rNum,int lNum,int n){
        if(rNum == n && lNum == n){
            reResult.add(new String(tmpResult));
            return;
        }
        if(lNum <n ){
            tmpResult[lNum+rNum] ='(';
            find(reResult, tmpResult, rNum, lNum+1, n);
        }
        if(lNum>rNum && rNum<n){
            tmpResult[lNum+rNum] = ')';
            find(reResult,tmpResult,rNum+1,lNum,n);
        }

    }

    public static void main(String[] args){
        Solution s = new Solution();
        List<String> result = s.generateParenthesis(3);
        System.out.println(result);
    }
}