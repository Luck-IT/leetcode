package eric;

import java.util.List;

/**
 * @author Eric Wu
 * @since 1.8
 * create 2022-02-09
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
