package eric;

import java.util.Arrays;

/**
* Solution
* 假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ：

perm[i] 能够被 i 整除
i 能够被 perm[i] 整除
给你一个整数 n ，返回可以构造的 优美排列 的 数量 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/beautiful-arrangement
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* @author:Eric
* @since 1.8
* create 2021年12月23日
*/
public class Solution {

    public int countArrangement(int n) {
        if(n <=0){
            return 0;
        }

        boolean[] flag = new boolean[n+1];
        Arrays.fill(flag, false);
        int[] count = new int[]{0};
        caculate(n, flag, count);
        return count[0];
    }

    private void caculate(int level,boolean[] flag,int[] count){
        int pos = flag.length -level;
        if(level == 1){
            for(int i=1;i<flag.length;i++){
                if(!flag[i]){
                    if( (i %pos==0) ||pos%i == 0){
                        count[0]++;
                    }
                    break;
                }
            }
            return;
        }else{
            for(int i= 1;i<flag.length;i++){
                if(!flag[i]){
                    if((i % pos == 0) || (pos% i == 0) ){
                        flag[i] = true;
                        caculate(level-1, flag, count);
                        flag[i] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.countArrangement(2);
        System.out.println(result);
    }
}
