<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=default"></script>
# [Solution338](https://leetcode-cn.com/problems/counting-bits/)
## description
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
### 1.解法一
&emsp;&emsp;计算每一个数的1的个数。由于java中int长度为4Byte，所以有32位，每一位都需要计算32次，所以总的时间复杂度为O(32(i+1)),即O(n);但是这里有一个技巧，每个数与比他小一的数按位与，会把当前数字的最低有效位变为0。例如:<img src="http://chart.googleapis.com/chart?cht=tx&chl= (3)_{10}=(0011)_2" style="border:none;">，<img src="http://chart.googleapis.com/chart?cht=tx&chl= (2)_{10}=(0010)_2" style="border:none;">,将两个数按位与，得到**0010**，如此进行下去，知道要求解的数为0，则有多少个1计算出来了。本题的方法一就是利用的该解法。这样可以避免从每一位进行计算。
### 2.解法二
&emsp;&emsp;我们知道整数除了奇数就是偶数，奇数转换为二进制后，最会一位一定为1，而偶数转换为二进制后，最后一位一定是0；所以奇数除以2之后，比所得的数字的二进制表示的1一定多1，而偶数是与其除以2之后所得的数字的二进制表示的1一样多，所以可以写出状态转移方程
>dp[i]=dp[i/2] +1 (i为奇数)，或者dp[i] = dp[i/2] (i为偶数)

