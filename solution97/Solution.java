public class Solution{

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        //-1:default,0:false,1:true
        //flag = 长度各+1，flag表示的是s3中前m+n的字符组成，所以需要各扩展1
        boolean[][] flag = new boolean[s1.length() + 1][s2.length() + 1];

        flag[0][0] = true;
        for(int i=1;i<=s2.length();i++){
            flag[0][i] = flag[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        }
        for(int i=1;i<=s1.length();i++){
            flag[i][0] = flag[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                flag[i][j] = (flag[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||( flag[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }

        return flag[s1.length()][s2.length()];
    }
}