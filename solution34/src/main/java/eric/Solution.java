package solution34;

import javax.swing.text.AbstractDocument.LeafElement;

/**
 * Solution
 * #description#
 * 
 * @author:Eric
 * @since 1.8
 *        create 2021年12月28日
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && start == -1) {
                start = i;
                end = i;
            } else if (nums[i] == target) {
                end++;
            } else if (nums[i] > target) {
                break;
            }
        }
        return new int[] { start, end };
    }

    /**
     * O(logN)解法
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int start = -2;
        int end = -2;
        int l = 0;
        int r = nums.length - 1;
        // 右边界
        while (l <= r) {
            int mid = l + (r - l)/2;
            if(nums[mid]<=target){
                l = mid+1;
                end = l;
            }else if(nums[mid]>target){
                r = mid-1;
            }
        }
        // 左边界
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid]>=target){
                r = r-1;
                start = r;
            }else if(nums[mid]<target){
                l= mid+1;
            }
        }
       if(start == -2 || end == -2) return new int[]{-1,-1};
       if(end-start>1) return new int[]{start+1,end-1};
       return new int[]{-1,-1};
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] result = s.searchRange2(new int[]{1}, 1);
        System.out.println(result);
    }
}
