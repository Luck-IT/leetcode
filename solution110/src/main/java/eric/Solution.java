package eric;

/**
 * @author Eric Wu
 * @since 1.8
 * create 2022-02-11
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null) {
            return countDepth(root.right) <= 1;
        }
        if (root.right == null) {
            return countDepth(root.left) <= 1;
        }
        if (isBalanced(root.left) && isBalanced(root.right)) {
            return Math.abs(countDepth(root.left) - countDepth(root.right)) > 1 ? false : true;
        }
        return false;


    }

    private int countDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = 0;
        if (root.left != null) {
            leftCount = countDepth(root.left);
        }
        int rightCount = 0;
        if (root.right != null) {
            rightCount = countDepth(root.right);
        }
        return (leftCount > rightCount ? leftCount : rightCount) + 1;
    }
}
