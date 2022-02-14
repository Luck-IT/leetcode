package eric;

import java.util.LinkedList;
import java.util.Queue;

public class Solution279 {

    /**
     * BFS 解法定义的节点
     */
    private static class Node {
        private int val;
        private int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }

        public int getVal() {
            return this.val;
        }

        public int getStep() {
            return this.step;
        }
    }

    /**
     * 动态规划解法
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int tmp = dp[i - j * j] + 1;
                dp[i] = dp[i] < tmp ? dp[i] : tmp;
            }
        }
        return dp[n];
    }

    /**
     * DFS解法
     */
    public int numSquares_2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] visited = new int[n + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 1));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (int i = 1;; i++) {
                int tmp = i * i;
                if (current.getVal() - tmp < 0) {
                    break;
                }
                if (current.getVal() - tmp == 0) {
                    return current.getStep();
                }
                if (visited[current.getVal() - tmp] == 0) {
                    queue.add(new Node(current.getVal() - tmp, current.getStep() + 1));
                    visited[current.getVal() - tmp] = 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution279 s = new Solution279();
        int result = s.numSquares(12);
        System.out.println(result);

        result = s.numSquares_2(13);
        System.out.println(result);
    }
}