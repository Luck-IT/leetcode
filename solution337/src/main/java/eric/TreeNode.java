package eric;

/**
* TreeNode
* #description#
* @author:Eric
* @since 1.8
* create Apr 13, 2022
*/
public class TreeNode {
    
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left ,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
