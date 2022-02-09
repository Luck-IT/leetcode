package eric;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Eric Wu
 * @since 1.8
 * create 2022-02-09
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root != null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            List<Integer> leve = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode tmp = queue.poll();
                leve.add(tmp.val);
                if(tmp.left!= null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
            result.add(leve);
        }
        return result;
    }
}
