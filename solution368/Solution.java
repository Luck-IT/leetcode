package solution368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        if (nums.length == 0) {
            return new ArrayList<Integer>(Arrays.asList(nums[0]));
        }
        // 按照从小到大排序
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        dp[0] = 1;
        pre[0] = -1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            pre[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
        }
        int maxPos = 0;
        for (int i = 1; i < nums.length; i++) {
            maxPos = dp[i] > dp[maxPos] ? i : maxPos;
        }
        List<Integer> result = new ArrayList<>();
        while (maxPos != -1) {
            result.add(nums[maxPos]);
            maxPos = pre[maxPos];
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> result = s.largestDivisibleSubset(new int[] { 2, 3, 1 });
        System.out.println(result);
    }
}