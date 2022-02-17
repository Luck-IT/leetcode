package eric;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
       
        Solution s = new Solution();
        List<List<Integer>> result = s.subsets(new int[]{1,2,3});
        System.out.println(result);
    }
}
