package eric;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public final class Solution {

    private Map<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null ){
            return 0;
        }
        return caculate(root);

    }

    int caculate(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = 0;
        if(node.left != null){
            if(map.containsKey(node.left)){
                left= map.get(node.left);
            }else{
                left = caculate(node.left);
                map.put(node.left,left);
            }
            
        }
        int right = 0;
        if(node.right != null){
            if(map.containsKey(node.right)){
                right = map.get(node.right);
            }else{
                right = caculate(node.right);
                map.put(node.right,right);
            }
            
        }
        
        //选则当前根节点则为
        //当前根左右子树的根节点与当前根节点和
        int maxIncludeRoot = (node.left == null?0:(caculate(node.left.left)+caculate(node.left.right)))+(node.right == null?0:(caculate(node.right.right)+caculate(node.right.left)))+node.val;

        //不选择当前根节点值
        int maxExcludeRoot = right+left;

        return Math.max(maxIncludeRoot, maxExcludeRoot);
    }
}
