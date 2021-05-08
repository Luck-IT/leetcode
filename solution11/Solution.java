package solution11;
/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 5/8/2021
*/
public class Solution {

    public int maxArea(int[] height) {
        if(height == null || height.length == 0 || height.length == 1){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<height.length;i++){
            for(int j=height.length-1;j>=i;j--){
                if(i ==j){
                   max = max>0?max:0;
                }else{
                    int tmp = (j-i)* (height[i]>height[j]?height[j]:height[i]);
                    max = tmp>max?tmp:max;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = new int[]{4,3,2,1,4};
        int result = s.maxArea(height);
        System.out.println(result);
    }

}
