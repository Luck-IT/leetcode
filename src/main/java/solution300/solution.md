# [Solution300](https://leetcode-cn.com/problems/longest-increasing-subsequence/)
## description
给定一个无序的整数数组，找到其中最长上升子序列的长度。

### 1.动态规划算法
&emsp;&emsp;声明一个长度为给定数组nums[]长度的数组dp[],其中dp[i]表示以nums[i]结尾的上升序列的最大长度。初始化dp[]数组，因为nums[]中的每一个元素可以做为该元素结尾的上升序列，所以dp[]每个数组初始化为1；动态规划状态转移方程：
```
dp[i] = max(max(dp[j]) + 1,dp[i]),其中j满足:0<=j<i,且nums[j]<nums[i]
```
&emsp;&emsp;当求解出dp[i]数组后，我们可以再此遍历的dp[i]数组，其中最大的元素则为本题的解。
&emsp;&emsp;由于我们在求解dp[i]时，每次都需要遍历dp[i]之前的每一个元素，所以该方法的时间复杂度O(n^2),空间复杂度n。

### 2.动态规划算法+二分查找法
&emsp;&emsp;解法1中，我们利用动态规划算法求解，其中每次求解时都需要遍历每一个之前的元素，如果我们可以把之前的元素进行一定的排序，然后进行二分查找，则可以降低时间复杂度。该解法与一种扑克牌有一定类似，具体可以[查看](https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-she-ji-fang-fa-zhi-pai-you-xi-jia/)。这里不再赘述。