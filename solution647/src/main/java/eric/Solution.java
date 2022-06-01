package eric;

import java.util.Arrays;

/**
 * Hello world!
 */
public class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // dp[i][j] 表示 以i开始，j结尾的字符串是否为回文,0 不是，1是
        int[][] dp = new int[s.length()][s.length()];
        // 递推公式
        // dp[i][j] =
        //      if s[i] != s[j] then
        //          0
        //      else
        //          dp[i+1][j-1]
        //      end if
        //
        // 初始化
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], 0);
        }

        // 遍历顺序
        // dp[i][j] 是通过左下角推断出来的，因此
        // 需要先【从下到上，从左到右】的顺序
        int resultCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = 1;
                        resultCount++;
                    }else{
                        if(dp[i+1][j-1] == 1){
                            dp[i][j] = 1;
                            resultCount++;
                        }
                    }
                }
            }
        }

        return resultCount;
    }
}
