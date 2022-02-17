package eric;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Solution
 * #description#
 * 
 * @author:Eric
 * @since 1.8
 *        create 2022年1月18日
 */
public class Solution {

    public List<String> restoreIpAddresses(String s) {
       
        List<String> result = new ArrayList<>();
        backTracing(result,new ArrayList<>(),s.toCharArray());
        return result;

    }

    private void backTracing(List<String> results, List<Integer> pos, char[] chars) {

       if(pos.size() == 3){
           int startPos = 0;
           List<String> one = new ArrayList<>();
           for(int i=0;i<pos.size();i++){
               String tmp = new String(Arrays.copyOfRange(chars, startPos, pos.get(i)));
               one.add(tmp);
               startPos = pos.get(i);
           }
           String last = new String(Arrays.copyOfRange(chars, startPos,chars.length));
           if(last.length()>3||Integer.valueOf(last)>255 || (last.length() > 1 && last.startsWith("0"))){
               return;
           }
           one.add(last);
           results.add(one.stream().collect(Collectors.joining(".")));
           return;
       }
       int prePos = pos.isEmpty()?0:pos.get(pos.size()-1);
       for(int i=pos.isEmpty()?1:pos.get(pos.size()-1)+1;i<chars.length;i++){
            pos.add(i);
            String tmp = new String(Arrays.copyOfRange(chars, prePos, i));
            if(tmp.length()>3||(tmp.startsWith("0") && tmp.length()>1) || Integer.valueOf(tmp)>255){
                pos.remove(pos.size()-1);
                return;
            }
            backTracing(results, pos, chars);
            pos.remove(pos.size()-1);
       }

    }

}
