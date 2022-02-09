package eric;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Eric Wu
 * @since 1.8
 * create 2022-02-09
 */
public class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return  result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){
                Node tmp = queue.poll();
                level.add(tmp.val);
                if(tmp.children != null && !tmp.children.isEmpty()){
                    for(Node n: tmp.children){
                        queue.add(n);
                    }
                }
            }
            result.add(level);
        }
        return result;
    }
}
