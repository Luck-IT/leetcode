# [Question264](https://leetcode-cn.com/problems/ugly-number-ii/)
## description
编写一个程序，找出第 n 个丑数。丑数就是只包含质因数 2, 3, 5 的正整数。

### 1.暴力求解
计算出给定范围内的所有丑数，返回第n个即可
```
Set<int> uglyNums = new HasSet<>;
for(int i = 1;i < Max.Integer;i = i * 2){
    for(int j= i;j < Max.Integer;j * 3){
        for(int k = j;j<Max.Integer;k*5){
            uglyNums.put(k);
        }
    }
}
//转换为list，排序
uglyNums.toList().sort();
//找到第n个数
```

### 2.动态规划
每一个丑数，都是由前一个数分别乘以 2，3，5 得到的。为了使得到的数有序，可以使用三个指针,p1,p2,p3;**dp[i]**表示第i个丑数，则:
```
dp[i] = min(dp[p1] * 2,dp[p2] * 3,dp[p3] * 5)
```
每次p1,p2,p3的移动根据dp[i]选择的最小的那个值来移动；

### 3.优先队列/小顶堆
由解法二我们可知，每次选取的数都是与2,3,5相乘后结果最小的那个，所以我们可以把相乘后的结果存入一个优先队列/小顶堆，每次把队列的第一个结果取出放入丑数的列表中，并从队列中弹出该值。直到得到第n个丑数。***注意：***，丑数6可以由2\*3得到，也可以由3\*2得到，也就说会出现重复的数字，所以我们要特别处理一下。

以上解法2，解法3代码请查看源代码。