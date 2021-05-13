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
        for(int i=0,j=height.length-1;i<j;){
            int tmp = (height[i]>height[j]?height[j]:height[i])*(j-i);
            max = tmp>max?tmp:max;
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return max;
    }

}
