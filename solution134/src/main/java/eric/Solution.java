package eric;

/**
 * Solution
 * #description#
 * 
 * @author:Eric
 * @since 1.8
 *        create 2022年1月18日
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int result = -1;
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return result;
        }
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (gasSum < costSum) {
            return result;
        }
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }
            int j = (i + 1) % gas.length;
            int tmp = gas[i] - cost[i];
            while (j != i && tmp > 0) {
                tmp = tmp + gas[j] - cost[j];
                j = (j + 1) % gas.length;
            }
            if (tmp >= 0) {
                result = i;
                break;
            }
        }
        return result;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {

        int result = -1;
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return result;
        }
        int sum = 0;
        int curSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        if (sum < 0) {
            return result;
        } else {
            result = start;
            return result;
        }

    }

}
