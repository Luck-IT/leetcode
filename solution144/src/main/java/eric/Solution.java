package eric;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //非递归方法
        Stack<TreeNode> st = new Stack<>();
        List<Integer> visited = new ArrayList<>();
        if(root == null){
            return visited;
        }
        st.push(root);
        while (!st.empty()){
            TreeNode top = st.peek();
            visited.add(top.val);
            st.pop();
            if(top.right != null){
                st.push(top.right);
            }
            if(top.left != null){
                st.push(top.left);
            }
        }
        return visited;
    }
}
