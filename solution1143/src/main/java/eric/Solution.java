package eric;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null ||  text1.length() == 0 || text2.length() == 0){
            return 0;
        }
        //1.dp 定义：dp[i][j] 表示 长度为text1[0..i-1] 与 长度为 text2[0..j-1]公共子序列长度

        int[][] dp = new int[text1.length()+1][text2.length()+1];

        //2. dp 递推公式
        // dp[i][j] =
        // if text1[i-1] == text2[j-1] then
        //      dp[i-1][j-1] + 1
        // else
        //      max(dp[i-1][j],dp[i][j-1])
        // end

        //3. dp初始化dp[0][0] = 0,dp[0][j] = 0,dp[i][0] = 0
        for(int i = 0;i<=text1.length();i++){
            dp[i][0] = 0;
        }
        for(int j= 0;j<=text2.length();j++){
            dp[0][j] = 0;
        }

        for(int i= 1;i<=text1.length();i++){
            for(int j= 1;j<=text2.length();j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
