package eric;

import java.util.Arrays;

public class Solution {

    public int findLength(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return 0;
        }
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int i = 0;i<=nums1.length;i++){
            Arrays.fill(dp[i],0);
        }
        for(int i = 1;i<=nums1.length;i++){
            for(int j=1;j<=nums2.length;j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
            }
        }
        return Arrays.stream(dp).flatMapToInt(v-> Arrays.stream(v)).max().getAsInt();
    }
}
