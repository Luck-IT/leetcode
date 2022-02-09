package eric;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Eric Wu
 * @since 1.8
 * create 2022-02-09
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            maxDepth++;
            for(int i = 0;i<levelSize;i++){
                TreeNode tmp = queue.poll();
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
        }
        return maxDepth;
    }
}
