package eric;

import java.util.*;

/**
 * @author Eric Wu
 * @since 1.8
 * create 2022-02-07
 */

public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null ){
            return Arrays.asList();
        }
        List<Integer> result = new ArrayList<>();

        TreeNode r = root;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (r != null || !stack.isEmpty()){
            while (r != null){
                stack.push(r);
                r = r.left;
            }
            r = stack.pop();
            if(r.right == null || r.right == pre){
                result.add(r.val);
                pre = r;
                r = null;
            }else{
                stack.push(r);
                r = r.right;
            }
        }
        return result;
    }
}
