import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 91
 */
public class Solution {

    public int numDecodings(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] numArrays = s.toCharArray();
        for (int i = 0; i < numArrays.length; i++) {
            if (numArrays[i] > '9' || numArrays[i] < '0') {
                return 0;
            }
        }
        List<Integer> results = new ArrayList<>(numArrays.length);
        for(int i=0;i<numArrays.length;i++){
            results.add(0);
        }
        if (s.length() >= 1) {
            if (numArrays[0] != '0') {
                results.set(0, 1);
            } else {
                return 0;
            }
        }
        if (s.length() >= 2) {
            int tmp = (numArrays[0] - '0') * 10 + (numArrays[1] - '0');
            if (tmp > 26 && numArrays[1] == '0') {
                results.set(1, 0);
            } else if (tmp > 26 && numArrays[1] != '0') {
                results.set(1, 1);
            } else if (tmp <= 26 && tmp>=10 && numArrays[1] != '0') {
                results.set(1, 2);
            } else if(tmp<=26 && tmp>=10 && numArrays[1] == '0'){
                results.set(1,1);
            }else if (tmp < 10 ) {
                results.set(1, 0);
            }
        }
        for (int i = 2; i < numArrays.length; i++) {
            if(numArrays[i] == '0'){
                if(numArrays[i-1] == '0'){
                    results.set(i,0);
                }else if(numArrays[i-1] <= '2' && numArrays[i-1]>'0'){
                    results.set(i,results.get(i-2));
                }else{
                    results.set(i,0);
                }
            }else if( numArrays[i] <= '6'){
                if(numArrays[i-1] == '0' ){
                    results.set(i,results.get(i-1));
                }else if(numArrays[i-1] <= '2'){
                    results.set(i,results.get(i-2)+results.get(i-1));
                }else{
                    results.set(i,results.get(i-1));
                }
            }else{
                if(numArrays[i-1] == '0'){
                    results.set(i,results.get(i-1));
                }else if(numArrays[i-1] == '1'){
                    results.set(i,results.get(i-2)+results.get(i-1));
                }else{
                    results.set(i,results.get(i-1));
                }
            }
        }
        return results.get(numArrays.length - 1);
    }

}