package eric;



import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric Wu
 * @since 1.8
 * create 2022-02-11
 */
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        findPath(root,result,new ArrayList<Integer>());
        return result;
    }

    private void findPath(TreeNode root,List<String> result,List<Integer> onePath){
        if(root == null){
            return;
        }
        onePath.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder tmp = new StringBuilder();
            tmp.append(onePath.get(0));
            for(int i=1;i<onePath.size();i++){
                tmp.append("->").append(onePath.get(i));
            }
            result.add(tmp.toString());
        }
        if(root.left != null){
            findPath(root.left,result,onePath);
        }
        if(root.right != null){
            findPath(root.right,result,onePath);
        }
        onePath.remove(onePath.size()-1);
    }

}
