package eric;

import java.util.*;

/**
 * @author Eric Wu
 * @since 1.8
 * create 2022-02-09
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode tmp = queue.poll();
                level.add(tmp.val);
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
            result.add(level);
        }
        List<List<Integer>> re = new ArrayList<>();
        for(int i=result.size()-1;i>=0;i--){
            re.add(result.get(i));
        }
        return re;
    }
}
