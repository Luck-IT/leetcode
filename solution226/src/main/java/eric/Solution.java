package eric;

/**
 * @author Eric Wu
 * @since 1.8
 * create 2022-02-10
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        invert(root);
        return root;
    }

    private void invert(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invert(root.left);
        invert(root.right);
    }
}
