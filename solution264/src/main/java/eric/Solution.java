package solution264;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 解决leetcode264号问题(https://leetcode-cn.com/problems/ugly-number-ii/)
 */
public class Solution {

    /**
     * 解法一 动态
     */
    public int nthUglyNumber(final int n) {
        if (n <= 0) {
            return -1;
        }
        final List<Integer> uglyList = new ArrayList<>();
        // the value of index 0 in uglyList is -1
        uglyList.add(-1);
        uglyList.add(1);
        int p1 = 1, p2 = 1, p3 = 1;
        for (int i = 2; i <= n; i++) {
            final int tmp2 = uglyList.get(p1) * 2;
            final int tmp3 = uglyList.get(p2) * 3;
            final int tmp5 = uglyList.get(p3) * 5;
            int tmpMin = tmp2 < tmp3 ? tmp2 : tmp3;
            tmpMin = tmp5 < tmpMin ? tmp5 : tmpMin;
            uglyList.add(tmpMin);
            if (tmp2 == tmpMin) {
                p1++;
            }
            if (tmp3 == tmpMin) {
                p2++;
            }
            if (tmp5 == tmpMin) {
                p3++;
            }
        }
        return uglyList.get(n);
    }

    /**
     * 解法2 优先级队列
     * 
     * @param n
     */
    public int nthUglyNumber_2(int n) {
        if (n <= 0) {
            return -1;
        }
        Queue<Integer> priorityQ = new PriorityQueue<>();
        Integer result = 1;
        for (int i = 2; i <= n; i++) {
            priorityQ.add(result * 2);
            priorityQ.add(result * 3);
            priorityQ.add(result * 5);
            result = priorityQ.poll();
            while(!priorityQ.isEmpty() && priorityQ.peek().equals(result)){
                priorityQ.poll();
            }
        }
        return result.intValue();
    }

    public static void main(final String[] args) {
        Solution s = new Solution();
        int result = s.nthUglyNumber(10);
        System.out.println(result);
        result = s.nthUglyNumber_2(10);
        System.out.println(result);
    }

}