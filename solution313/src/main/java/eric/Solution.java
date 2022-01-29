package solution313;

import java.util.Arrays;
import java.util.stream.Stream;

/**
* 313
超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。

给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。

题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。

* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2021年12月22日
 */

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int dp[] = new int[n+1];
        int length = primes.length;
        int pointers[] = new int[length];
        int nums[] = new int[length];
        Arrays.fill(nums,1);
        for(int i = 1;i<=n;i++){
            int minNums = Arrays.stream(nums).min().getAsInt();
            dp[i] = minNums;
            for(int j=0;j<length;j++){
                if(minNums == nums[j]){
                    pointers[j]++;
                    nums[j] = dp[pointers[j]]*primes[j];
                }
            }
        }
        return dp[n];
    }
}
