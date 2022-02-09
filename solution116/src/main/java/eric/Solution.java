package eric;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Eric Wu
 * @since 1.8
 * create 2022-02-09
 */
public class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            Node pre = queue.peek();
            for (int i = 0; i < levelSize; i++) {
                Node tmp = queue.poll();
                if (pre != tmp) {
                    pre.next = tmp;
                    pre = tmp;
                }
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
        }
        return root;
    }
}
