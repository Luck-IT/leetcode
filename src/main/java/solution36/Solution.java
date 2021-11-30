package solution36;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* Solution
* #description#
* @author:Eric
* @since 1.8
        * create 2021年11月30日
        */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> mats = new ArrayList<>();

        for(int i = 0;i<9;i++){
            rows.add(new HashSet<Character>());
            cols.add(new HashSet<Character>());
            mats.add(new HashSet<Character>());
        }

        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                Character posChar= board[i][j];
                if(posChar.equals('.')){
                    continue;
                }
                if(rows.get(i).contains(posChar)){
                    return false;
                }else{
                    rows.get(i).add(posChar);
                }

                if(cols.get(j).contains(posChar)){
                    return false;
                }else{
                    cols.get(j).add(posChar);
                }

                int matsPos = (i/3)*3+j/3;
                if(mats.get(matsPos).contains(posChar)){
                    return false;
                }else{
                    mats.get(matsPos).add(posChar);
                }
            }
        }
        return true;
    }
}
