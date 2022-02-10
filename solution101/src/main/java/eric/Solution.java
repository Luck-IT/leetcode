package eric;

/**
 * @author Eric Wu
 * @since 1.8
 * create 2022-02-10
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetricRecu(root.left,root.right);
    }

    /**
     * 递归方式
     * @param root
     * @return
     */
    private boolean isSymmetricRecu(TreeNode left,TreeNode right){
       if(left == null && right !=null){
           return false;
       }else if(left != null && right == null){
           return false;
       }else if(left == null && right == null){
           return true;
       }else{
           if(left.val != right.val){
               return false;
           }else{
               boolean out = isSymmetricRecu(left.left,right.right);
               boolean inner = isSymmetricRecu(left.right,right.left);
               return out && inner;
           }
       }
    }
}

