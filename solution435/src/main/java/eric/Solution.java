package eric;

import java.util.Arrays;

/**
 * Solution
 * #description#
 * 
 * @author:Eric
 * @since 1.8
 *        create 2021年12月27日
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals[0].length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (v1, v2) -> v1[1] - v2[1]);
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] test = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        Solution s = new Solution();
        int result = s.eraseOverlapIntervals(test);
        System.out.println(result);
    }
}