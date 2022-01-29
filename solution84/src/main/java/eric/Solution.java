package eric;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        return compute(heights);

    }

    private int compute(int[] heights) {
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        int[] tmp = new int[heights.length + 2];
        for (int i = 1; i <= heights.length; i++) {
            tmp[i] = heights[i-1];
        }
        tmp[tmp.length-1] = Integer.MIN_VALUE;
        tmp[0] = Integer.MIN_VALUE;
        heights = tmp;
        for (int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                int curHeight = heights[stack.pop()];
                int curleft = stack.peek();
                int curRight = i;
                int area = (curRight-curleft-1 )*curHeight;
                max = Integer.max(area, max);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int result = s.largestRectangleArea(new int[] { 0,0 });
        System.out.println(result);
    }

}