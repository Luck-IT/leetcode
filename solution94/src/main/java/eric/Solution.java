package eric;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Eric Wu
 * @since 1.8
 * create 2022-02-08
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //递归算法
        recursionTravel(root,result);
        return result;
    }

    //递归算法
    private void recursionTravel(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }
        if(root.left != null){
            recursionTravel(root.left,result);
        }
        result.add(root.val);
        if(root.right != null){
            recursionTravel(root.right,result);
        }
    }

    //迭代算法
    private void iterativeTravel(TreeNode root,List<Integer> result){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode r = root;
        while (r != null || !stack.isEmpty()){
            while (r != null){
                stack.push(r);
                r = r.left;
            }
            TreeNode tmp = stack.pop();
            result.add(tmp.val);
            r = tmp.right;
        }
    }

}
