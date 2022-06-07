package eric;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return new int[0];
        }
        if (nums2 == null || nums2.length == 0) {
            int[] tmp = new int[nums1.length];
            Arrays.fill(tmp, -1);
            return tmp;
        }
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            int top = stack.peek();

            while (nums2[i] > top && !stack.isEmpty()) {
                top = stack.pop();
                if (map.containsKey(top)) {
                    result[map.get(top)] = nums2[i];
                }
                if(!stack.isEmpty()){
                    top = stack.peek();
                }
            }
            stack.push(nums2[i]);
        }
        return result;
    }
}
