package eric;

/**
 * Hello world!
 *
 */
public class Solution
{
    public int minDistance(String word1, String word2) {
        //1
        //dp[i][j] 表示以word[i-1] 和 word[j-1]结尾的达到公共的字符串最小次数
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //2
        //递推公式
        // dp[i][j] =
        //      if word[i-1] == word[j-1] then
        //          dp[i-1][j-1]
        //      else
        //         min{dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+2}
        //      end if
        //3
        //初始化
        //  dp[i][0] = i;dp[1][0] = j
        for(int i=0;i<=word1.length();i++){
            dp[i][0] = i;
        }
        for(int j= 0;j<= word2.length();j++){
            dp[0][j] = j;
        }
        //遍历顺序
        //  从小到大
        for(int i = 1;i<=word1.length();i++){
            for(int j= 1;j<=word2.length();j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] =Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+2));
                }
            }
        }
        return dp[word1.length()][word2.length()];

    }
}
