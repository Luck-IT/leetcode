package eric;

/**
 * Hello world!
 *
 */
public class Solution 
{
    public int maxProfit(int[] prices) {

        int result = 0;
        //greeting algorithm    
        if(prices != null || prices.length >2){
            
            for(int i=1;i<prices.length;i++){
                if(prices[i]-prices[i-1]>0){
                    result+=prices[i]-prices[i-1];
                }
            }
        }
        return result;
    }
}
