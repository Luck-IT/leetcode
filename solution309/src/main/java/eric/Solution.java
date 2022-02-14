package eric;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2021年11月22日
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null||prices.length ==0){
            return 0;
        }
        int HAVE_NOBUY = 0;
        int  NO_FREEZE=1;
        int NO_NOFREEZE = 2;
        int[][] f = new int[prices.length][3];
  
        f[0][HAVE_NOBUY] = -prices[0];
        f[0][NO_FREEZE] = 0;
        f[0][NO_NOFREEZE] =0;

        for(int i=1;i<prices.length;i++){
           f[i][HAVE_NOBUY] = Math.max(f[i-1][NO_NOFREEZE] - prices[i],f[i-1][HAVE_NOBUY]);
           f[i][NO_FREEZE] = f[i-1][HAVE_NOBUY]+prices[i];
           f[i][NO_NOFREEZE] = Math.max(f[i-1][NO_FREEZE], f[i-1][NO_NOFREEZE]);
        }

        return Math.max(f[prices.length-1][NO_FREEZE],f[prices.length-1][NO_NOFREEZE]);

    }
}
