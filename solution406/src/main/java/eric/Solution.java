package eric;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return null;
        }
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        for (int i = 1; i < people.length; i++) {
            if (people[i][1] < i) {
                int[][] tmp = new int[][] { { people[i][0], people[i][1] } };
                int j = i;
                for(;tmp[0][1]!=j && j>0;j--){
                    people[j][0] = people[j-1][0];
                    people[j][1] = people[j-1][1];
                }
                people[j][0] = tmp[0][0];
                people[j][1] = tmp[0][1];
            }

        }
        return people;
    }
}
