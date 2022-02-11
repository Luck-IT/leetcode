package eric;

/**
 * @author Eric Wu
 * @since 1.8
 * create 2022-02-11
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftCount = 0;
        if(root.left != null){
            leftCount = countNodes(root.left);
        }
        int rightCount=0;
        if(root.right != null){
            rightCount = countNodes(root.right);
        }
        return leftCount + rightCount +1;
    }
}
