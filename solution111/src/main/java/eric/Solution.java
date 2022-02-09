package eric;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int minDepth(TreeNode root) {

        return minDepthRecursion(root);
    }

    /**
     * 递归算法
     *
     * @param root
     * @return
     */
    private int minDepthRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftDepth = Integer.MAX_VALUE;
        if(root.left != null){
            leftDepth = minDepthRecursion(root.left);
        }
        int rightDepth = Integer.MAX_VALUE;
        if(root.right != null){
            rightDepth = minDepthRecursion(root.right);
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * 迭代算法
     * @param root
     * @return
     */
    private int minDepthIterator(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minDepth = 0;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            boolean continueFlag = true;
            for(int i = 0;i<levelSize;i++){
                TreeNode tmp = queue.poll();
                if(tmp.left == null && tmp.right == null){
                    continueFlag = false;
                }
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
            minDepth++;
            if(!continueFlag){
                break;
            }
        }
        return minDepth;
    }
}
