package eric;

class Solution {
    public int[] countBits(int num) {
        if(num<0){
            return null;
        }
        if(num == 0){
            return new int[]{0};
        }
        return solution1(num);
    }

    //解法一
    private int[] solution1(int num){
        int[] result = new int[num+1];
        for(int i=0;i<=num;i++){
            int temp = 0;
            int tempNum = i;
            while(tempNum>0){
                tempNum &= (tempNum-1);
                temp++;
            }
            result[i] = temp;
        }
        return result;
    }

    //解法二
    //利用之前计算的结果
    private int[] solution2(int num){
        int[] result = new int[num+1];
        result[0] = 0;
        result[1] = 1;
        for(int i=2;i<=num;i++){
            result[i] = i%2 == 0 ? result[i/2]:result[i/2]+1;
        }
        return result;
    }
}