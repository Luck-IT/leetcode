package solution343;

public class Solution {

    public int integerBreak(int n) {
        int[] result = new int[] { Integer.MIN_VALUE };
        // integerBreakHelp(1, result,n,n);
        return integerBreakHelp2(n);
    }

    private void integerBreakHelp(Integer curr, int[] max, int num, int iniNum) {
        for (int i = 1; i <= num; i++) {
            if (num - i == 0 && iniNum != num) {
                if (curr * i > max[0]) {
                    max[0] = curr * i;
                }
            } else if (num - i > 0) {
                curr = curr * i;
                integerBreakHelp(curr, max, num - i, iniNum);
                curr = curr / i;
            } else {
                break;
            }
        }
    }

    private int integerBreakHelp2(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                max = Math.max(max,dp[i-j]*j);
                max = Math.max(max,(i-j)*j);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.integerBreak(10));
        System.out.println(s.integerBreak(2));
        System.out.println(s.integerBreak(28));

    }
}