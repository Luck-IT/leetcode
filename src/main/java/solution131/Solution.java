package solution131;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2021/5/19
*/
public class Solution {

    public List<List<String>> partition(String s){

        if(s == null || "".equals(s)){
            return Collections.EMPTY_LIST;
        }
        List<List<String>> result =new ArrayList<>();
        dfs(s,0,new ArrayList<String>(),result);
        return result;
    }

    private void dfs(String s,int start,List<String> path,List<List<String>> result){
     
        if(start == s.length()){
            result.add(new ArrayList<>(path));
        }

        for(int j = start;j<s.length();j++){
            if(j == start){
                path.add(String.valueOf(s.charAt(j)));
                dfs(s,j+1,path,result);
                path.remove(path.size()-1);
            }
            else if(check(s, start, j)){
                path.add(s.substring(start,j+1));
                dfs(s,j+1,path,result);
                path.remove(path.size()-1);
            }
        }
    }

    boolean check(String s,int i,int j){
        if(j>s.length()){
            return false;
        }
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s  = new Solution();
        System.out.print(s.partition("aab"));
    }
    
}
