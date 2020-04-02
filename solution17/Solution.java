package solution17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    private static final List<String[]> NUMBER_MAP = Stream.of(new String[1], new String[1],
            new String[] { "a", "b", "c" }, new String[] { "d", "e", "f" }, new String[] { "g", "h", "i" },
            new String[] { "j", "k", "l" }, new String[] { "m", "n", "o" }, new String[] { "p", "q", "r", "s" },
            new String[] { "t", "u", "v" }, new String[] { "w", "x", "y", "z" }).collect(Collectors.toList());

    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return new ArrayList<>();
        }
        char[] tmp = new char[10];
        List<String> result =new ArrayList<>();
        help(0, digits, tmp, result);
        return result;
    }

    private void help(int digitsIndex,String digits,char[] tmp,List<String> result){
        if(digitsIndex>=digits.length()){
            return;
        }
        for(String chStr:NUMBER_MAP.get(digits.charAt(digitsIndex)-'0')){
            tmp[digitsIndex] = chStr.charAt(0);
            if(digitsIndex == digits.length()-1){
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<=digitsIndex;i++){
                    sb.append(tmp[i]);
                }
                result.add(sb.toString());
            }else{
                help(digitsIndex+1, digits, tmp, result);
            }

        }
    }

}