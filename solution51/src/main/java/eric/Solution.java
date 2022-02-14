package eric;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
public class Solution {

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return null;
        }
        List<List<String>> result = new ArrayList<>(n);
        List<StringBuilder> ones = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringBuilder one = new StringBuilder();
            for (int j = 0; j < n; j++) {
                one.append(".");
            }
            ones.add(one);
        }
        findAllPossible(0, result, ones, n);
        return result;
    }

    private void findAllPossible(int level, List<List<String>> result, List<StringBuilder> ones, int n) {
        if (level >= n) {
            return;
        }
        StringBuilder one = ones.get(level);
        for (int i = 0; i < n; i++) {
            one.setCharAt(i, 'Q');
            if (check(ones, level, i)) {
                if (level < n - 1) {
                    findAllPossible(level + 1, result, ones, n);
                } else if (level == n - 1) {
                    List<String> tmp = ones.stream().map(StringBuilder::toString).collect(Collectors.toList());
                    result.add(tmp);
                }
            }
            one.setCharAt(i, '.');
        }
    }

    private boolean check(List<StringBuilder> ones, int row, int col) {
        for (int i = 0; i < ones.size(); i++) {
            if (ones.get(i).charAt(col) == 'Q' && i != row) {
                return false;
            }
        }

        int r = row - 1;
        int c = col + 1;
        // left 
        while (r >= 0 && c < ones.size()) {
            if (ones.get(r).charAt(c) == 'Q') {
                return false;
            }
            r = r - 1;
            c = c + 1;
        }
        r = row + 1;
        c = c - 1;
        while (r < ones.size() && c >= 0) {
            if (ones.get(r).charAt(c) == 'Q') {
                return false;
            }
            r = r + 1;
            c = c - 1;
        }

        //right
        r = row - 1;
        c = col - 1;
        while (r >= 0 && c >= 0) {
            if (ones.get(r).charAt(c) == 'Q') {
                return false;
            }
            r = r - 1;
            c = c - 1;
        }

        r = row + 1;
        c = col + 1;
        while (r < ones.size() && c < ones.size()) {
            if (ones.get(r).charAt(c) == 'Q') {
                return false;
            }
            r = r + 1;
            c = c + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solveNQueens(4);
    }

}