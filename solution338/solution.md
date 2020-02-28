<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=default"></script>
# [Solution338](https://leetcode-cn.com/problems/counting-bits/)
## description
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
### 1.解法一
&emsp;&emsp;计算每一个数的1的个数。由于java中int长度为4Byte，所以有32位，每一位都需要计算32次，所以总的时间复杂度为O(32(i+1)),即O(n);但是这里有一个技巧，每个数与比他小一的数按位与，会把当前数字的最低有效位变为0。例如:\\(3)_10 = (0011)_2\\,\\(2)_10=(0010)2,3&2=\\(0010)\\。如此进行下去，知道要求解的数为0，则有多少个1计算出来了。本题的方法一就是利用的该解法。这样可以避免从每一位进行计算。