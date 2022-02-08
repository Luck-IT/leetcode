package eric;

import java.util.*;

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

    /**
     * 递归算法
     * @param root
     * @param result
     */
    private void recuriteTravel(TreeNode root,List<Integer> result){
        if(root != null){
            result.add(root.val);
        }
        if(root.left != null){
            recuriteTravel(root.left,result);
        }
        if(root.right != null){
            recuriteTravel(root.right,result);
        }
    }

    /**
     * 迭代算法
     * @param root
     * @param result
     */
    private void iterateTravle(TreeNode root,List<Integer> result){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode r = root;
        while (r != null || !stack.isEmpty()){

            while (r != null){
                result.add(r.val);
                stack.push(r);
                r = r.left;
            }
            r = stack.pop();
            r = r.right;
        }
    }

}
