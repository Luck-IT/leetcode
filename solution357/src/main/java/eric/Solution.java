package solution357;

import java.util.ArrayList;
import java.util.List;


/**
* Solution
* #description#
* @author:Eric
* @since 1.8
* create 2021年9月18日
*/
public class Solution {




    private List<Integer> resultList = new ArrayList<>();

    public int countNumbersWithUniqueDigits(int n) {
        this.resultList.add(1);
        this.resultList.add(10);
        if(n<= 0){
            return resultList.get(0);
        }
        if(n<2){
            return resultList.get(n);
        }

        for(int i = 2;i<=n;i++){
            int tmp = caculate(piv(10,i-1),piv(10,i));
            tmp = resultList.get(i-1)+tmp;
            resultList.add(tmp);
        }
        return resultList.get(n);

    }

    private int piv(int base,int n){
        int result = 1;
        while(n-->0){
            result*=base;
        }
        return result;
    }

    private int caculate(int start,int end){
        int result = 0;
        int[] flag = new int[10];
        for(int i =0;i<10;i++){
            flag[i] = -1;
        }
        for(int i = start;i<end;i++){
            int tmp = i;
            while(tmp>0){
                if(flag[tmp%10] == 1){
                    result++;
                    break;
                }else{
                    flag[tmp%10] = 1;
                }
                tmp /=10;
            }
            for(int j=0;j<10;j++){
                flag[j] = -1;
            }
        }
        return end-start-result;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        long start = System.currentTimeMillis();
        int result = s.countNumbersWithUniqueDigits(10);
        System.out.println((System.currentTimeMillis()-start)/1000.0);
        System.out.println("===========");
    }
}
