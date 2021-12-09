package solution392;



public class Solution{
    public boolean isSubsequence(String s, String t) {
        if(t.equals(s) && "".equals("")){
            return true;
        }
        if(t == null || "".equals(t)){
            return false;
        }
        if(s == null || "".equals(s)){
            return true;
        }
        int si = 0;
        int ti =0;
        for(ti = 0;ti<t.length();ti++){
            if(t.charAt(ti) == s.charAt(si)){
                si++;
                if(si>=s.length()){
                    break;
                }
            }
        }
        if(si == s.length()){
            return true;
        }
        return false;
        
    }


    //动态规划算法
    public boolean isSubsequence2(String s, String t) {
        if(t.equals(s) && "".equals("")){
            return true;
        }
        if(t == null || "".equals(t)){
            return false;
        }
        if(s == null || "".equals(s)){
            return true;
        }
        int[][] f = new int[t.length()][26];
        for(int i=0;i<t.length();i++){
            for(int j=0;j<26;j++){
                f[i][j] = -1;
            }
        }
        for(int i = 0;i<t.length();i++){
            for(int j=i;j<t.length();j++){
                f[j][t.charAt(i)-'a'] = i;
            }
        }
        int i = 0;
        for(int j=0;j<s.length();j++){
            int tmp = f[i][s.charAt(j)-'a'];
            if(tmp !=-1){
                i = tmp+1;
            }else{
                i++;
            }
            if(i>=t.length()){
                return false;
            }
        }
        return false;
    }
}