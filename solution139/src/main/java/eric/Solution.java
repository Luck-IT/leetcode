package eric;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class Solution 
{
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> word = new HashSet(wordDict);
        //字符串长度为i的是否能包含词典序列中若干单词
        Boolean dp[] = new Boolean[s.length()+1];
        Arrays.fill(dp,false);
        //字符串为空时，包含词典序列中“空”单词
        dp[0] = true;

        for(int i = 1;i<=s.length();i++){
            for(int j = 0;j<i;j++){
                String tmp = s.substring(j,i);
                if(word.contains(tmp) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
